package dev.graczykmateusz.githubstatistics.github.client;

import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class GithubUserMapper {

  static GithubUserClientDataDto toDto(GithubUser githubUser) {
    return new GithubUserClientDataDto(
        githubUser.id(),
        githubUser.login(),
        githubUser.name(),
        githubUser.type(),
        githubUser.avatarUrl(),
        githubUser.createdAt(),
        githubUser.calculations());
  }
}
