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
  private readonly _allGithubUserStatistics: WritableSignal<GithubUserStatistic[]> = signal([]);
  
  get allGithubUserStatistics(): Signal<GithubUserStatistic[]> {
    return computed(() => this._allGithubUserStatistics());
  }
  
  updateCount(githubUserStatistic: GithubUserStatistic): void {
    this._allGithubUserStatistics.update((arr: GithubUserStatistic[]) => {
      // Find the index of the user in the array
      const index = arr.findIndex(v => v.login === githubUserStatistic.login);
      
      // Create a new array to ensure reactivity
      const newArr = [...arr];
      
      if (index !== -1) {
        // If the user exists, update the count
        newArr[index].count = githubUserStatistic.count;
      } else {
        // If the user does not exist, add the new githubUserStatistic
        newArr.push(githubUserStatistic);
      }
      
      return newArr;
    });
  }
  
  refreshAllUsersStatistics(): void {
    const url: string = ApiBuilder.api.v1.users('all').statistics.build();
    this.http.get<GithubUserStatistic[]>(url)
      .pipe(first())
      .subscribe((v: GithubUserStatistic[]) => this._allGithubUserStatistics.set(v));
  }
}
