package dev.graczykmateusz.githubstatistics.github.user.statistic.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Configuration(proxyBeanMethods = false)
public class GithubUserStatisticKafkaListenerConfiguration {
  
  @Bean("githubUserStatisticKafkaListener")
  GithubUserStatisticKafkaListener githubUserStatisticKafkaListener(
      SimpMessagingTemplate messagingTemplate) {
    return new GithubUserStatisticKafkaListener(messagingTemplate);
  }
}
