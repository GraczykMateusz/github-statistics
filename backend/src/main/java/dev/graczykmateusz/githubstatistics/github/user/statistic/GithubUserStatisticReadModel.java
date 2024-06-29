package dev.graczykmateusz.githubstatistics.github.user.statistic;

import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
class GithubUserStatisticReadModel {

  private String login;
  private long count;
}
