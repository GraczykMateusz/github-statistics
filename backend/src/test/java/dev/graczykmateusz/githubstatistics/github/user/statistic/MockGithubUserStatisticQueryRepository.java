package dev.graczykmateusz.githubstatistics.github.user.statistic;

import java.util.List;

class MockGithubUserStatisticQueryRepository implements GithubUserStatisticQueryRepository {

  private final List<GithubUserStatisticReadModel> data =
      List.of(
          new GithubUserStatisticReadModel("LOGIN_1", 1),
          new GithubUserStatisticReadModel("LOGIN_2", 2));

  @Override
  public List<GithubUserStatisticReadModel> findAll() {
    return data;
  }
}
