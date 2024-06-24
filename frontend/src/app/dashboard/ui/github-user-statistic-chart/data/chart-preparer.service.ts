import { Injectable } from '@angular/core';
import { GithubUserStatistic } from '../../../data/statistic/github-user-statistic';

@Injectable({
  providedIn: 'root'
})
export class ChartPreparerService {
  
  prepare(allGithubUserStatistics: GithubUserStatistic[] | []) {
    return {
      labels: allGithubUserStatistics.map(value => value.login),
      datasets: [
        {data: allGithubUserStatistics.map(value => value.count)}
      ]
    };
  }
}
