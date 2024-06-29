import { Injectable } from '@angular/core';
import { GithubUserStatistic } from '../../../data/statistic/github-user-statistic';
import { ChartConfiguration } from 'chart.js';
import { MyChartData } from './my-chart-data';

@Injectable({
  providedIn: 'root'
})
export class ChartPreparerService {
  
  prepare(allGithubUserStatistics: GithubUserStatistic[]): MyChartData {
    return {
      labels: allGithubUserStatistics.map(v => v.login),
      datasets: [
        {data: allGithubUserStatistics.map(v => v.count), label: 'Number of calls'}
      ]
    };
  }
  
  getOptions(): ChartConfiguration<'bar'>['options'] {
    return {
      maintainAspectRatio: false
    };
  }
}
