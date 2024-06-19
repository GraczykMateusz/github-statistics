import { Injectable } from '@angular/core';
// import { Socket } from 'ngx-socket-io';
import { take } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class GithubUserStatisticService {
  
  private stompClient!: Stomp.Client;
  
  constructor(private http: HttpClient) {
  }
  
  private serverUrl = 'http://localhost:8080/ws'; // Replace with your WebSocket endpoint
  
  connectToWebSocket() {
    var socket = new SockJS(this.serverUrl); // Replace with your WebSocket endpoint
    this.stompClient = Stomp.over(socket);
    console.log('weszlo')
    this.stompClient.connect({}, (frame) => {
      console.log('Connected: ' + frame);
      this.stompClient.subscribe('/topic/github/user/updates', (message) => {
        console.log('Received: ' + message.body);
        // Handle received message here
      });
    });
  }
  
  x() {
    this.http.get('/api/v1/users/a/a').pipe(take(1)).subscribe((r: any) => console.log(r));
  }
}
