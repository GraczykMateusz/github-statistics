package dev.graczykmateusz.githubstatistics.github.user.statistic;

import dev.graczykmateusz.githubstatistics.abstraction.event.DomainEventListener;
import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@RequiredArgsConstructor
class GetGithubUserWasExecutedListener implements DomainEventListener<GetGithubUserWasExecuted> {

  private final GithubUserStatisticRepository repository;

  @Async
  @EventListener
  @Override
  public void listen(GetGithubUserWasExecuted event) {
    var githubUserStatistic = GithubUserStatisticMapper.toDomain(event);
    repository.incrementCount(githubUserStatistic);
  }
}
