package dev.graczykmateusz.githubstatistics.github.user.statistic.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@RequiredArgsConstructor
public class GithubUserStatisticKafkaListener {
  
  private final SimpMessagingTemplate messagingTemplate;
  
  @KafkaListener(topics = "pg-changes.public.github_user_statistic", groupId = "debezium-events1")
  public void consume(String message) {
    System.out.println("Consumed message: " + message);
    messagingTemplate.convertAndSend("/topic/github/user/updates", message); // Send message to WebSocket clients
  }
}
