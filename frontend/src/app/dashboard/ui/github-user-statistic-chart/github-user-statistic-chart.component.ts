import { Component, inject } from '@angular/core';
import { GithubUserStatisticService } from '../../data/github-user-statistic.service';

@Component({
  selector: 'app-github-user-statistic-chart',
  standalone: true,
  imports: [],
  templateUrl: './github-user-statistic-chart.component.html',
  styleUrl: './github-user-statistic-chart.component.scss'
})
export class GithubUserStatisticChartComponent {
  
  private readonly githubUserStatisticService = inject(GithubUserStatisticService);
}
