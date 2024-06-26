import { Injectable } from '@angular/core';
import { GithubUserStatistic } from '../../../data/statistic/github-user-statistic';
import { ChartConfiguration, ChartData } from 'chart.js';

@Injectable({
  providedIn: 'root'
})
export class ChartPreparerService {
  
  prepare(allGithubUserStatistics: GithubUserStatistic[]): ChartData {
    return {
      labels: allGithubUserStatistics.map(value => value.login),
      datasets: [
        {data: allGithubUserStatistics.map(value => value.count), label: 'Number of calls'}
      ]
    };
  }
  
  getOptions(): ChartConfiguration<'bar'>['options'] {
    return {
      maintainAspectRatio: false
    };
  }
}
