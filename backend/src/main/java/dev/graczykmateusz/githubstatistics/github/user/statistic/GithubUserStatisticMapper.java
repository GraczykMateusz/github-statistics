package dev.graczykmateusz.githubstatistics.github.user.statistic;

import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import dev.graczykmateusz.githubstatistics.github.user.statistic.dto.GithubUserStatisticDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class GithubUserStatisticMapper {

  static GithubUserStatisticSaveModel toDomain(GetGithubUserWasExecuted event) {
    return new GithubUserStatisticSaveModel(event.login());
  }

  static GithubUserStatisticDto toDto(GithubUserStatisticReadModel rm) {
    return new GithubUserStatisticDto(rm.getLogin(), rm.getCount());
  }
}
