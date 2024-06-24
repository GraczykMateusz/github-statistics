package dev.graczykmateusz.githubstatistics.github.user.statistic;

import lombok.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GithubUserStatisticReadModel {

  private String login;
  private long count;
}
