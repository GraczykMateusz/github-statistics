package dev.graczykmateusz.githubstatistics.github.user.statistic;

import dev.graczykmateusz.githubstatistics.github.user.statistic.dto.GithubUserStatisticDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Slf4j
@RequiredArgsConstructor
class GithubUserStatisticKafkaListener {

  private static final String TOPIC = "/topic/github-user-statistic";

  private final SimpMessagingTemplate messagingTemplate;

  @KafkaListener(
      topics = "pg-changes.public.github_user_statistic",
      groupId = "github-user-statistic-consumer")
  void consume(GithubUserStatisticDto payload) {
    log.info("Received statistic: " + payload);
    messagingTemplate.convertAndSend(TOPIC, payload);
  }
}
