package dev.graczykmateusz.githubstatistics.github.client;

import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
class GithubClientImpl implements GithubClient {

  private final WebClient webClient;
  private final GithubClientExceptionHandler exceptionHandler;

  @Override
  public Mono<GithubUserClientDataDto> getUser(String login) {
    return webClient
        .get()
        .uri("/users/" + login)
        .retrieve()
        .onStatus(HttpStatus.NOT_FOUND::equals, response -> exceptionHandler.handleNotFound(login))
        .onStatus(
            HttpStatusCode::is5xxServerError, response -> exceptionHandler.handleServerError(login))
        .onStatus(
            HttpStatusCode::is4xxClientError, response -> exceptionHandler.handleClientError(login))
        .bodyToMono(GithubUser.class)
        .map(GithubUserMapper::toDto)
        .onErrorResume(
            WebClientRequestException.class, e -> exceptionHandler.handleRequestError(login, e));
  }
}
