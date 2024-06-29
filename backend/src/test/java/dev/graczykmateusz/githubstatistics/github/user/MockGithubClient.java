package dev.graczykmateusz.githubstatistics.github.user;

import dev.graczykmateusz.githubstatistics.github.client.GithubClient;
import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import java.time.Instant;
import reactor.core.publisher.Mono;

class MockGithubClient implements GithubClient {

  private GithubUserClientDataDto response =
      new GithubUserClientDataDto(
          1L, "graczykmateusz", "GraczykMateusz", "user", "xxx", Instant.MAX, 1.2);

  @Override
  public Mono<GithubUserClientDataDto> getUser(String login) {
    return Mono.just(response);
  }

  public void setReturn(GithubUserClientDataDto response) {
    this.response = response;
  }
}
