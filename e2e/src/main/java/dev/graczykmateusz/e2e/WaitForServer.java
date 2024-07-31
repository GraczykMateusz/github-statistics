package dev.graczykmateusz.e2e;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.logging.Logger;

public class WaitForServer {

  private static final Logger log = Logger.getLogger(WaitForServer.class.getName());

  public static void main(String[] args) throws InterruptedException {
    String url = "http://github-statistics-app:8081/actuator/health";
    int timeoutSeconds = 120;
    long startTime = System.currentTimeMillis();

    while (!isServerHealthy(url)) {
      log.info("Waiting for the server to start...");
      Thread.sleep(5000); // Check every 5 seconds

      // Check if timeout exceeded
      long elapsedTime = System.currentTimeMillis() - startTime;
      if (elapsedTime > timeoutSeconds * 1000) {
        log.warning("Timeout reached. Server did not start within " + timeoutSeconds + " seconds.");
        throw new RuntimeException("Exit");
      }
    }
    log.info("Server has started and is healthy");
  }

  private static boolean isServerHealthy(String urlString) {
    try {
      HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(2)).build();
      HttpRequest request =
          HttpRequest.newBuilder()
              .uri(new URI(urlString))
              .timeout(Duration.ofSeconds(2))
              .GET()
              .build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() == 200) {
        return true;
      }
    } catch (Exception ignore) {
      // Log the exception if needed
    }
    return false;
  }
}
