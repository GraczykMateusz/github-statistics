import { computed, inject, Injectable, Signal, signal, WritableSignal } from '@angular/core';
import { GithubUserStatistic } from '../github-user-statistic';
import { ApiBuilder } from '../../../../shared/api.builder';
import { first } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GithubUserStatisticService {
  
  private readonly http: HttpClient = inject(HttpClient);
  private readonly _allGithubUserStatistics: WritableSignal<GithubUserStatistic | undefined> = signal(undefined);
  
  get allGithubUserStatistics(): Signal<GithubUserStatistic | undefined> {
    return computed(() => this._allGithubUserStatistics());
  }
  
  refreshAllUsersStatistics(): void {
    const url: string = ApiBuilder.api.v1.users('all').statistics.build();
    this.http.get<GithubUserStatistic>(url)
      .pipe(first())
      .subscribe((value: GithubUserStatistic) => this._allGithubUserStatistics.set(value));
  }
}
