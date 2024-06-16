import { Component } from '@angular/core';
import { GithubUserStatisticChartComponent } from './ui/github-user-statistic-chart/github-user-statistic-chart.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    GithubUserStatisticChartComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

}
