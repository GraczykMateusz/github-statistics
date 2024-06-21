import { Component, inject } from '@angular/core';
import { ChartConfiguration } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { GithubUserStatisticListenerService } from '../../data/listener/github-user-statistic-listener.service';

@Component({
  selector: 'app-github-user-statistic-chart',
  standalone: true,
  imports: [
    BaseChartDirective
  ],
  templateUrl: './github-user-statistic-chart.component.html',
  styleUrl: './github-user-statistic-chart.component.scss'
})
export class GithubUserStatisticChartComponent {
  
  private readonly githubUserStatisticListenerService = inject(GithubUserStatisticListenerService);
  readonly data = this.githubUserStatisticListenerService.data();
  
  barChartData: ChartConfiguration<'bar'>['data'] = {
    labels: ['2006', '2007', '2008', '2009', '2010', '2011', '2012'],
    datasets: [
      {data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A'}
    ]
  };
  
  barChartOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: false
  };
}
