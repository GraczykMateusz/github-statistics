package dev.graczykmateusz.e2e;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class WaitForServer {
  public static void main(String[] args) throws InterruptedException {
    String host = "localhost";
    int port = 8080; // Change this to your server's port
    int timeoutSeconds = 15;
    long startTime = System.currentTimeMillis();

    while (!isServerRunning(host, port)) {
      System.out.println("Waiting for the server to start...");
      Thread.sleep(5000); // Check every 5 seconds

      // Check if timeout exceeded
      long elapsedTime = System.currentTimeMillis() - startTime;
      if (elapsedTime > timeoutSeconds * 1000) {
        System.out.println("Timeout reached. Server did not start within " + timeoutSeconds + " seconds.");
        return;
      }
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
