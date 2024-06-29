package dev.graczykmateusz.githubstatistics.github.user;

import dev.graczykmateusz.githubstatistics.MockEventPublisher;
import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandler;
import dev.graczykmateusz.githubstatistics.github.user.dto.GithubUserDto;
import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import dev.graczykmateusz.githubstatistics.github.user.query.GetGithubUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

class GetGithubUserQueryHandlerTest {

  private final MockGithubClient githubClient = new MockGithubClient();
  private final MockEventPublisher<GetGithubUserWasExecuted> eventPublisher =
      new MockEventPublisher<>();

  private final QueryHandler<GithubUserDto, GetGithubUser> handler =
      new GithubUserConfiguration().getGithubUserQueryHandler(githubClient, eventPublisher);

  @Test
  @DisplayName(
      "Should handle GetGithubUser request and "
          + "return expected GithubUserDto when github user exists")
  void handle() {
    var getGithubUser = new GetGithubUser("graczykmateusz");

    var expectedGithubUser =
        new GithubUserDto(1L, "graczykmateusz", "GraczykMateusz", "user", "xxx", Instant.MAX, 1.2);

    Mono<GithubUserDto> result = handler.handle(getGithubUser);

    StepVerifier.create(result)
        .expectNext(expectedGithubUser)
        .verifyComplete();

    assertThat(eventPublisher.getEvents())
        .containsExactly(new GetGithubUserWasExecuted("graczykmateusz"));
  }
}
