package dev.graczykmateusz.githubstatistics.github.client;

import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
class GithubClientImpl implements GithubClient {

  private final WebClient webClient;

  @Override
  public Mono<GithubUserClientDataDto> getUser(String login) {
    return webClient
        .get()
        .uri("/users/" + login)
        .retrieve()
        .bodyToMono(GithubUser.class)
        .map(GithubUserMapper::toDto);
  }
}
