package dev.graczykmateusz.githubstatistics.github.user;

import dev.graczykmateusz.githubstatistics.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
@RequiredArgsConstructor
class GetGithubUserWasExecutedPublisher implements DomainEventPublisher<GetGithubUserWasExecuted> {

  private final ApplicationEventPublisher eventPublisher;

  @Override
  public void publish(GetGithubUserWasExecuted event) {
    log.info("Publishing event: {}", event);
    eventPublisher.publishEvent(event);
  }
}
