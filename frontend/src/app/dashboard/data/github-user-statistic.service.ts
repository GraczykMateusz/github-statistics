import { Injectable } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class GithubUserStatisticService {
  
  private stompClient!: Stomp.Client;
  
  private serverUrl = 'http://localhost:8080/ws'; // Replace with your WebSocket endpoint
  
  connectToWebSocket() {
    var socket = new SockJS(this.serverUrl); // Replace with your WebSocket endpoint
    this.stompClient = Stomp.over(socket);
    this.stompClient.connect({}, (frame) => {
      console.log('Connected: ' + frame);
      this.stompClient.subscribe('/topic/github/user/updates', (message) => {
        console.log('Received: ' + message.body);
        // Handle received message here
      });
    });
  }
}
