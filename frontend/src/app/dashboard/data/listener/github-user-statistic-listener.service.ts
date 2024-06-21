import { computed, Injectable, signal } from '@angular/core';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';

@Injectable({
  providedIn: 'root'
})
export class GithubUserStatisticListenerService {
  
  private readonly socket = new SockJS('http://localhost:8080/ws');
  private readonly stompClient = Stomp.over(this.socket);
  
  constructor() {
    this.stompClient.connect({}, (frame) => {
      this.stompClient.subscribe('/topic/github-user-statistic', (message) => {
        this._data.set(message.body);
      });
    });
  }
  
  private readonly _data = signal('');
  
  get data() {
    return computed(() => this._data);
  }
}
