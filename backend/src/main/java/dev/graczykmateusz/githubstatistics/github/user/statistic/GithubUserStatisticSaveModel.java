package dev.graczykmateusz.githubstatistics.github.user.statistic;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
class GithubUserStatisticSaveModel {

  private String login;
}
