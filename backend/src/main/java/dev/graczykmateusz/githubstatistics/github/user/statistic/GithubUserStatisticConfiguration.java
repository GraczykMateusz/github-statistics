package dev.graczykmateusz.githubstatistics.github.user.statistic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GithubUserStatisticConfiguration {

  @Bean("getGithubUserWasExecutedListener")
  GetGithubUserWasExecutedListener getGithubUserWasExecutedListener(
      GithubUserStatisticRepository repository) {
    return new GetGithubUserWasExecutedListener(repository);
  }
}
