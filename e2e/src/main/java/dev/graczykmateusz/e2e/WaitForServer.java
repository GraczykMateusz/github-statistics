package dev.graczykmateusz.e2e;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class WaitForServer {
  public static void main(String[] args) throws InterruptedException {
    String host = "localhost";
    int port = 8080; // Change this to your server's port

    while (!isServerRunning(host, port)) {
      System.out.println("Waiting for the server to start...");
      Thread.sleep(5000);
    }
    System.out.println("Server has started");
  }

  private static boolean isServerRunning(String host, int port) {
    try (Socket socket = new Socket()) {
      socket.connect(new InetSocketAddress(host, port), 2000);
      return true;
    } catch (IOException e) {
      return false;
    }
  }
}
