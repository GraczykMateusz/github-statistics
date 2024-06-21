import { Component, inject, OnInit, Signal } from '@angular/core';
import { ChartConfiguration } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { GithubUserStatisticListenerService } from '../../data/statistic/listener/github-user-statistic-listener.service';
import { GithubUserStatisticService } from '../../data/statistic/client/github-user-statistic.service';
import { GithubUserStatistic } from '../../data/statistic/github-user-statistic';

@Component({
  selector: 'app-github-user-statistic-chart',
  standalone: true,
  imports: [
    BaseChartDirective
  ],
  templateUrl: './github-user-statistic-chart.component.html',
  styleUrl: './github-user-statistic-chart.component.scss'
})
export class GithubUserStatisticChartComponent implements OnInit {
  
  private readonly githubUserStatisticListenerService = inject(GithubUserStatisticListenerService);
  private readonly githubUserStatisticService = inject(GithubUserStatisticService);
  
  private readonly allGithubUserStatistics: Signal<GithubUserStatistic | undefined> = this.githubUserStatisticService.allGithubUserStatistics;
  private readonly githubUserStatistic: Signal<GithubUserStatistic | undefined> = this.githubUserStatisticListenerService.githubUserStatistic;
  
  ngOnInit(): void {
    this.githubUserStatisticService.refreshAllUsersStatistics();
  }
  
  barChartData: ChartConfiguration<'bar'>['data'] = {
    labels: ['2006', '2007', '2008', '2009', '2010', '2011', '2012'],
    datasets: [
      {data: [65, 59, 80, 81, 56, 55, 40]}
    ]
  };
  
  barChartOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: false
  };
}
