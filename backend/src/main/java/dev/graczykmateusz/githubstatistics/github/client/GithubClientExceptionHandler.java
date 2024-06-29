package dev.graczykmateusz.githubstatistics.github.client;

import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import dev.graczykmateusz.githubstatistics.github.client.exception.GithubClientException;
import dev.graczykmateusz.githubstatistics.github.client.exception.GithubUserNotFoundException;
import reactor.core.publisher.Mono;

class GithubClientExceptionHandler {

  public Mono<Throwable> handleNotFound(String login) {
    return Mono.error(new GithubUserNotFoundException("User not found: " + login));
  }

  public Mono<Throwable> handleServerError(String login) {
    return Mono.error(new GithubClientException("Server error for user: " + login));
  }

  public Mono<Throwable> handleClientError(String login) {
    return Mono.error(new GithubClientException("Client error for user: " + login));
  }

  public Mono<GithubUserClientDataDto> handleRequestError(String login, Throwable e) {
    return Mono.error(new GithubClientException("Request error for user: " + login, e));
  }

  public Mono<GithubUserClientDataDto> handleUnexpectedError(String login, Throwable e) {
    return Mono.error(new GithubClientException("Unexpected error for user: " + login, e));
  }
}
