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
  private readonly _allGithubUserStatistics: WritableSignal<GithubUserStatistic[] | []> = signal([]);
  
  get allGithubUserStatistics(): Signal<GithubUserStatistic[] | []> {
    return computed(() => this._allGithubUserStatistics());
  }
  
  updateCount(githubUserStatistic: GithubUserStatistic) {
    this._allGithubUserStatistics.update(arr => arr.map(v => {
      if (v.login === githubUserStatistic.login) {
        v.count = githubUserStatistic.count;
      }
      return v;
    }));
  }
  
  refreshAllUsersStatistics(): void {
    const url: string = ApiBuilder.api.v1.users('all').statistics.build();
    this.http.get<GithubUserStatistic[]>(url)
      .pipe(first())
      .subscribe((v: GithubUserStatistic[]) => this._allGithubUserStatistics.set(v));
  }
}
