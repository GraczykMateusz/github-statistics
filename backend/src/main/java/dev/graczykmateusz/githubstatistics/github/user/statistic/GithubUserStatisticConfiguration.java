package dev.graczykmateusz.githubstatistics.github.user.statistic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Configuration(proxyBeanMethods = false)
class GithubUserStatisticConfiguration {

  @Bean("githubUserStatisticKafkaListener")
  GithubUserStatisticKafkaListener githubUserStatisticKafkaListener(
      SimpMessagingTemplate messagingTemplate) {
    return new GithubUserStatisticKafkaListener(messagingTemplate);
  }

  @Bean("getGithubUserWasExecutedListener")
  GetGithubUserWasExecutedListener getGithubUserWasExecutedListener(
      GithubUserStatisticRepository repository) {
    return new GetGithubUserWasExecutedListener(repository);
  }
}
