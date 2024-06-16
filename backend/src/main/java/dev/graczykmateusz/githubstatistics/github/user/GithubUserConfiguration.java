package dev.graczykmateusz.githubstatistics.github.user;

import dev.graczykmateusz.githubstatistics.abstraction.event.EventPublisher;
import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandler;
import dev.graczykmateusz.githubstatistics.github.client.GithubClient;
import dev.graczykmateusz.githubstatistics.github.user.dto.GithubUserDto;
import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import dev.graczykmateusz.githubstatistics.github.user.query.GetGithubUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class GithubUserConfiguration {

  @Bean("getGithubUserWasExecutedPublisher")
  EventPublisher<GetGithubUserWasExecuted> getGithubUserWasExecutedPublisher() {
    return new GetGithubUserWasExecutedPublisher();
  }

  @Bean("getGithubUserQueryHandler")
  QueryHandler<GithubUserDto, GetGithubUser> getGithubUserQueryHandler(
          GithubClient client, EventPublisher<GetGithubUserWasExecuted> publisher) {
    return new GetGithubUserQueryHandler(client, publisher);
  }
}
