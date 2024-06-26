import { computed, Injectable, Signal, signal, WritableSignal } from '@angular/core';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import { GithubUserStatistic } from '../github-user-statistic';
import { environment } from '../../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GithubUserStatisticListenerService {
  
  private readonly socket = new SockJS(environment.localhostWS);
  private readonly stompClient = Stomp.over(this.socket);
  
  private readonly _githubUserStatistic: WritableSignal<GithubUserStatistic | undefined> = signal(undefined);
  
  constructor() {
    this.stompClient.connect({}, (frame) => {
      this.stompClient.subscribe(environment.topicGithubUserStatistic, (message) => {
        try {
          const parsedMessage = JSON.parse(message.body) as GithubUserStatistic;
          this._githubUserStatistic.set(parsedMessage);
        } catch (error) {
          console.error('Error parsing message:', error);
        }
      });
    });
  }
  
  get githubUserStatistic(): Signal<GithubUserStatistic | undefined> {
    return computed(() => this._githubUserStatistic());
  }
}
