import { Component, computed, effect, inject, OnInit, Signal } from '@angular/core';
import { BaseChartDirective } from 'ng2-charts';
import { GithubUserStatisticListenerService } from '../../data/statistic/listener/github-user-statistic-listener.service';
import { GithubUserStatisticService } from '../../data/statistic/client/github-user-statistic.service';
import { GithubUserStatistic } from '../../data/statistic/github-user-statistic';
import { AsyncPipe } from '@angular/common';
import { ChartPreparerService } from './data/chart-preparer.service';
import { ChartConfiguration } from 'chart.js';

@Component({
  selector: 'app-github-user-statistic-chart',
  standalone: true,
  imports: [
    BaseChartDirective,
    AsyncPipe
  ],
  templateUrl: './github-user-statistic-chart.component.html',
  styleUrl: './github-user-statistic-chart.component.scss'
})
export class GithubUserStatisticChartComponent implements OnInit {
  
  private readonly githubUserStatisticListenerService = inject(GithubUserStatisticListenerService);
  private readonly githubUserStatisticService = inject(GithubUserStatisticService);
  private readonly chartPreparerService = inject(ChartPreparerService);
  
  private readonly allGithubUserStatistics: Signal<GithubUserStatistic[] | []> = this.githubUserStatisticService.allGithubUserStatistics;
  private readonly updatedGithubUserStatistic: Signal<GithubUserStatistic | undefined> = this.githubUserStatisticListenerService.githubUserStatistic;
  
  readonly chart = computed(() => this.chartPreparerService.prepare(this.allGithubUserStatistics()));
  
  barChartOptions: ChartConfiguration<'bar'>['options'] = {
    responsive: false
  };
  
  constructor() {
    effect(() => {
      if (this.updatedGithubUserStatistic()) {
        this.githubUserStatisticService.updateCount(this.updatedGithubUserStatistic()!);
      }
    }, {allowSignalWrites: true});
  }
  
  ngOnInit(): void {
    this.githubUserStatisticService.refreshAllUsersStatistics();
  }
}
