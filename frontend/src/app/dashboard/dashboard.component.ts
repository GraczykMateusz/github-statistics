import { Component, inject, OnInit } from '@angular/core';
import { GithubUserStatisticChartComponent } from './ui/github-user-statistic-chart/github-user-statistic-chart.component';
import { GithubUserStatisticService } from './data/github-user-statistic.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    GithubUserStatisticChartComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {
  
  private readonly web = inject(GithubUserStatisticService);
  
  ngOnInit() {
    this.web.connectToWebSocket();
  }
}
