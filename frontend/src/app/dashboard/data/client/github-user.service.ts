import { computed, inject, Injectable, Signal, signal, WritableSignal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GithubUser } from './github-user';
import { catchError, EMPTY, first } from 'rxjs';
import { ApiBuilder } from '../../../shared/data/api.builder';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ErrorModalComponent } from '../../../shared/ui/error-modal/error-modal.component';

@Injectable({
  providedIn: 'root'
})
export class GithubUserService {
  
  private readonly ngbModal = inject(NgbModal);
  private readonly http: HttpClient = inject(HttpClient);
  private readonly _githubUser: WritableSignal<GithubUser | undefined> = signal(undefined);
  
  get githubUser(): Signal<GithubUser | undefined> {
    return computed(() => this._githubUser());
  }
  
  refreshUserData(login: string): void {
    const url: string = ApiBuilder.api.v1.users(login).build();
    this.http.get<GithubUser>(url)
      .pipe(
        first(),
        catchError(err => {
          this._githubUser.set(undefined);
          this.openErrorModal(err.error);
          return EMPTY;
        }))
      .subscribe((value: GithubUser) => this._githubUser.set(value));
  }
  
  private openErrorModal(message: string): void {
    const modal = this.ngbModal.open(ErrorModalComponent,
      {ariaLabelledBy: 'modal-basic-title', backdrop: 'static'}
    );
    modal.componentInstance.message = message;
  }
}
