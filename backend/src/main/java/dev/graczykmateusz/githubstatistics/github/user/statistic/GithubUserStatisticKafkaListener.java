package dev.graczykmateusz.githubstatistics.github.user.statistic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Slf4j
@RequiredArgsConstructor
class GithubUserStatisticKafkaListener {
  
  private final SimpMessagingTemplate messagingTemplate;
  
  @KafkaListener(topics = "pg-changes.public.github_user_statistic", groupId = "debezium-events1")
  void consume(String s) {
    log.info(s);
    messagingTemplate.convertAndSend("/topic/github-user-statistic", s);
  }
}
