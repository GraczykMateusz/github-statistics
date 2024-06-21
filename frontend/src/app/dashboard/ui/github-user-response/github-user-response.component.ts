import { Component, inject, Signal } from '@angular/core';
import { GithubUserService } from '../../data/client/github-user.service';
import { GithubUser } from '../../data/client/github-user';

@Component({
  selector: 'app-github-user-response',
  standalone: true,
  imports: [],
  templateUrl: './github-user-response.component.html',
  styleUrl: './github-user-response.component.scss'
})
export class GithubUserResponseComponent {
  
  private readonly githubUserService: GithubUserService = inject(GithubUserService);
  readonly githubUser: Signal<GithubUser | undefined> = this.githubUserService.githubUser;
}
