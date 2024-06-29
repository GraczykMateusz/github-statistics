package dev.graczykmateusz.githubstatistics.github.user.statistic;

import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandler;
import dev.graczykmateusz.githubstatistics.github.user.statistic.dto.GithubUserStatisticDto;
import dev.graczykmateusz.githubstatistics.github.user.statistic.query.GetAllGithubUsersStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class GetAllGithubUserStatisticQueryHandlerTest {

  private final GithubUserStatisticQueryRepository queryRepository =
      new MockGithubUserStatisticQueryRepository();
  private final QueryHandler<GithubUserStatisticDto, GetAllGithubUsersStatistics> handler =
      new GithubUserStatisticConfiguration().getAllGithubUserStatisticQueryHandler(queryRepository);

  @Test
  @DisplayName(
      "Should handle GetAllGithubUsersStatistics request and "
          + "return expected GithubUserStatisticDtos when statistics are present in the database")
  void handleMany() {
    var getAllGithubUsersStatistics = new GetAllGithubUsersStatistics();

    Flux<GithubUserStatisticDto> result = handler.handleMany(getAllGithubUsersStatistics);

    StepVerifier.create(result)
        .expectNext(
            new GithubUserStatisticDto("LOGIN_1", 1), new GithubUserStatisticDto("LOGIN_2", 2))
        .verifyComplete();
  }
}
