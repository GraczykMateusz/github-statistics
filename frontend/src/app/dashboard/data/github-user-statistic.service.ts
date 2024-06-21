import { Injectable } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class GithubUserStatisticService {
  
  private readonly socket = new SockJS('http://localhost:8080/ws');
  private readonly stompClient = Stomp.over(this.socket);
  
  connectToWebSocket() {
    this.stompClient.connect({}, (frame) => {
      console.log('Connected: ' + frame);
      this.stompClient.subscribe('/topic/github/user/updates', (message) => {
        console.log('Received: ' + message.body);
        // Handle received message here
      });
    });
  }
}
