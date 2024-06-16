package dev.graczykmateusz.githubstatistics.github.user.statistic;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
class GithubUserStatisticReadModel {

  private String login;
  private String count;
}
