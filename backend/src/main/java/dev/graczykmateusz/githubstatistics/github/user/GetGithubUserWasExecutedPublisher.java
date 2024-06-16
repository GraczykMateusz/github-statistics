package dev.graczykmateusz.githubstatistics.github.user;

import dev.graczykmateusz.githubstatistics.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
class GetGithubUserWasExecutedPublisher implements DomainEventPublisher<GetGithubUserWasExecuted> {

  private final ApplicationEventPublisher eventPublisher;

  @Override
  public void publish(GetGithubUserWasExecuted event) {
    eventPublisher.publishEvent(event);
  }
}
