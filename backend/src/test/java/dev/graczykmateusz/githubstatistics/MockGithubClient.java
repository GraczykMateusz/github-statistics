package dev.graczykmateusz.githubstatistics;

import dev.graczykmateusz.githubstatistics.github.client.GithubClient;
import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import java.time.Instant;
import reactor.core.publisher.Mono;

public class MockGithubClient implements GithubClient {

  @Override
  public Mono<GithubUserClientDataDto> getUser(String login) {
    var githubUserClientData =
        new GithubUserClientDataDto(
            1L, "graczykmateusz", "GraczykMateusz", "user", "xxx", Instant.MAX, 1.2);
    return Mono.just(githubUserClientData);
  }
}
