package dev.graczykmateusz.githubstatistics.github.user;

import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import dev.graczykmateusz.githubstatistics.github.user.dto.GithubUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class GithubUserMapper {

  static Mono<GithubUserDto> toDto(GithubUserClientDataDto githubUserClientData) {
    return Mono.just(
        new GithubUserDto(
            githubUserClientData.id(),
            githubUserClientData.login(),
            githubUserClientData.name(),
            githubUserClientData.type(),
            githubUserClientData.avatarUrl(),
            githubUserClientData.createdAt(),
            githubUserClientData.calculations()));
  }
}
