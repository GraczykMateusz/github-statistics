package dev.graczykmateusz.githubstatistics.github.user;

import dev.graczykmateusz.githubstatistics.abstraction.event.EventPublisher;
import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;

class GetGithubUserWasExecutedPublisher implements EventPublisher<GetGithubUserWasExecuted> {

  @Override
  public void publish(GetGithubUserWasExecuted event) {}
}
