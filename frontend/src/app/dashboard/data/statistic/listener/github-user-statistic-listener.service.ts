import { computed, Injectable, signal, WritableSignal } from '@angular/core';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import { GithubUserStatistic } from '../github-user-statistic';

@Injectable({
  providedIn: 'root'
})
export class GithubUserStatisticListenerService {
  
  private readonly socket = new SockJS('http://localhost:8080/ws');
  private readonly stompClient = Stomp.over(this.socket);
  
  private readonly _githubUserStatistic: WritableSignal<GithubUserStatistic | undefined> = signal(undefined);
  
  constructor() {
    this.stompClient.connect({}, (frame) => {
      this.stompClient.subscribe('/topic/github-user-statistic', (message) => {
        this._githubUserStatistic.set(undefined);
      });
    });
  }
  
  get githubUserStatistic() {
    return computed(() => this._githubUserStatistic);
  }
}
