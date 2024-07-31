package dev.graczykmateusz.e2e;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.logging.Logger;

public class WaitForConnector {

  private static final Logger log = Logger.getLogger(WaitForConnector.class.getName());

  public static void main(String[] args) throws InterruptedException {
    String url = "http://connect:8083/connectors/";
    int timeoutSeconds = 100;
    long startTime = System.currentTimeMillis();

    while (!isConnectorSetUp(url)) {
      log.info("Waiting for the connector to set up...");
      Thread.sleep(5000); // Check every 5 seconds

      // Check if timeout exceeded
      long elapsedTime = System.currentTimeMillis() - startTime;
      if (elapsedTime > timeoutSeconds * 1000) {
        log.warning(
            "Timeout reached. Connector did not set up within " + timeoutSeconds + " seconds.");
        throw new RuntimeException("Exit");
      }
    }
    log.info("Connector has set up");
  }

  private static boolean isConnectorSetUp(String urlString) {
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
        // Parse the JSON array response
        String responseBody = response.body();

        if (responseBody.contains("postgresql-connector")) {
          return true;
        }
      }
    } catch (Exception ignore) {
      // Log the exception if needed
    }
    return false;
  }
}
