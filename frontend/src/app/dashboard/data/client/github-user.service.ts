import { computed, inject, Injectable, Signal, signal, WritableSignal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GithubUser } from './github-user';
import { first } from 'rxjs';
import { ApiBuilder } from '../../../shared/api.builder';

@Injectable({
  providedIn: 'root'
})
export class GithubUserService {
  
  private readonly http: HttpClient = inject(HttpClient);
  private readonly _githubUser: WritableSignal<GithubUser | undefined> = signal(undefined);
  
  get githubUser(): Signal<GithubUser | undefined> {
    return computed(() => this._githubUser());
  }
  
  refreshUserData(login: string): void {
    const url: string = ApiBuilder.api.v1.users(login).build();
    this.http.get<GithubUser>(url)
      .pipe(first())
      .subscribe((value: GithubUser) => this._githubUser.set(value));
  }
}
