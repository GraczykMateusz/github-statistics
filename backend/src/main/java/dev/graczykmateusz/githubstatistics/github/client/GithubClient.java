package dev.graczykmateusz.githubstatistics.github.client;

import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import reactor.core.publisher.Mono;

public interface GithubClient {

  Mono<GithubUserClientDataDto> getUser(String login);
}
