package dev.graczykmateusz.githubstatistics.github.user;

import dev.graczykmateusz.githubstatistics.abstraction.event.DomainEventPublisher;
import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandler;
import dev.graczykmateusz.githubstatistics.github.client.GithubClient;
import dev.graczykmateusz.githubstatistics.github.user.dto.GithubUserDto;
import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import dev.graczykmateusz.githubstatistics.github.user.query.GetGithubUser;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class GithubUserConfiguration {

  @Bean("getGithubUserWasExecutedPublisher")
  DomainEventPublisher<GetGithubUserWasExecuted> getGithubUserWasExecutedPublisher(
      ApplicationEventPublisher eventPublisher) {
    return new GetGithubUserWasExecutedPublisher(eventPublisher);
  }

  @Bean("getGithubUserQueryHandler")
  QueryHandler<GithubUserDto, GetGithubUser> getGithubUserQueryHandler(
      GithubClient githubClient, DomainEventPublisher<GetGithubUserWasExecuted> publisher) {
    return new GetGithubUserQueryHandler(githubClient, publisher);
  }
}
