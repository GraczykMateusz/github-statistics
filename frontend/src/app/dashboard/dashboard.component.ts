import { Component, inject } from '@angular/core';
import { GithubUserStatisticChartComponent } from './ui/github-user-statistic-chart/github-user-statistic-chart.component';
import { GithubUserService } from './data/client/github-user.service';
import { FormControl, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    GithubUserStatisticChartComponent,
    ReactiveFormsModule
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
  
  private readonly githubUserService: GithubUserService = inject(GithubUserService);
  
  readonly loginControl: FormControl = new FormControl('', Validators.required);
  
  getUserData(): void {
    const login = this.loginControl.value;
    this.githubUserService.getUserData(login);
  }
}
