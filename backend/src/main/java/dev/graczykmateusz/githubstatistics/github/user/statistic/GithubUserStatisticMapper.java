package dev.graczykmateusz.githubstatistics.github.user.statistic;

import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class GithubUserStatisticMapper {

  static GithubUserStatisticSaveModel toDomain(GetGithubUserWasExecuted event) {
    return new GithubUserStatisticSaveModel(event.login());
  }
}
