package dev.graczykmateusz.githubstatistics.github.client;

import static org.assertj.core.api.Assertions.assertThat;

import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import dev.graczykmateusz.githubstatistics.github.client.exception.GithubClientException;
import dev.graczykmateusz.githubstatistics.github.client.exception.GithubUserNotFoundException;
import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class GithubClientTest {

  private static MockWebServer mockWebServer;
  private static WebClient mockedWebClient;

  private final GithubClient client = new GithubClientConfiguration().githubClient(mockedWebClient);

  @BeforeAll
  static void setUp() {
    mockWebServer = new MockWebServer();
    mockedWebClient = WebClient.builder().baseUrl(mockWebServer.url("/").toString()).build();
  }

  @AfterAll
  static void tearDown() throws IOException {
    mockWebServer.close();
  }

  @Test
  @DisplayName("Should retrieve user details successfully from Github API")
  void shouldRetrieveSuccessfully() throws InterruptedException {
    mockWebServer.enqueue(
        new MockResponse()
            .setResponseCode(HttpStatus.OK.value())
            .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .setBody(GithubResponse.JSON));

    Mono<GithubUserClientDataDto> result = client.getUser("testuser");

    StepVerifier.create(result).expectNext(ExpectedGithubClientData.DATA).verifyComplete();

    RecordedRequest recordedRequest = mockWebServer.takeRequest();
    assertThat(recordedRequest.getPath()).isEqualTo("/users/testuser");
  }

  @Test
  @DisplayName("Should throw GithubUserNotFoundException when user is not found on Github")
  void shouldThrowGithubUserNotFoundException() throws InterruptedException {
    mockWebServer.enqueue(
        new MockResponse()
            .setResponseCode(HttpStatus.NOT_FOUND.value())
            .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .setBody(StatusNotFoundResponse.JSON));

    Mono<GithubUserClientDataDto> result = client.getUser("testuser");

    StepVerifier.create(result).expectError(GithubUserNotFoundException.class).verify();

    RecordedRequest recordedRequest = mockWebServer.takeRequest();
    assertThat(recordedRequest.getPath()).isEqualTo("/users/testuser");
  }

  @Test
  @DisplayName("Should throw GithubClientException on server error")
  void shouldThrowGithubClientExceptionOnServerError() throws InterruptedException {
    mockWebServer.enqueue(
        new MockResponse()
            .setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .setBody(StatusInternalServerErrorResponse.JSON));

    Mono<GithubUserClientDataDto> result = client.getUser("testuser");

    StepVerifier.create(result).expectError(GithubClientException.class).verify();

    RecordedRequest recordedRequest = mockWebServer.takeRequest();
    assertThat(recordedRequest.getPath()).isEqualTo("/users/testuser");
  }

  @Test
  @DisplayName("Should throw GithubClientException on client error")
  void shouldThrowGithubClientExceptionOnClientError() throws InterruptedException {
    mockWebServer.enqueue(
        new MockResponse()
            .setResponseCode(HttpStatus.BAD_REQUEST.value())
            .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .setBody(StatusBadRequestResponse.JSON));

    Mono<GithubUserClientDataDto> result = client.getUser("testuser");

    StepVerifier.create(result).expectError(GithubClientException.class).verify();

    RecordedRequest recordedRequest = mockWebServer.takeRequest();
    assertThat(recordedRequest.getPath()).isEqualTo("/users/testuser");
  }
}
