package dev.graczykmateusz.githubstatistics.github.user.statistic;

import dev.graczykmateusz.githubstatistics.abstraction.event.DomainEventListener;
import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@Slf4j
@RequiredArgsConstructor
class GetGithubUserWasExecutedListener implements DomainEventListener<GetGithubUserWasExecuted> {

  private final GithubUserStatisticRepository repository;

  @Async
  @EventListener
  @Override
  public void listen(GetGithubUserWasExecuted event) {
    log.info("Received event {}", event);
    var githubUserStatistic = GithubUserStatisticMapper.toDomain(event);
    repository.incrementCount(githubUserStatistic);
  }
}
