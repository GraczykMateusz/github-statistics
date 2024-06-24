package dev.graczykmateusz.githubstatistics.github.user.statistic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.graczykmateusz.githubstatistics.github.user.statistic.dto.GithubUserStatisticDto;
import org.apache.kafka.common.serialization.Deserializer;

public class GithubUserStatisticKafkaDeserializer implements Deserializer<GithubUserStatisticReadModel> {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  @Override
  public GithubUserStatisticReadModel deserialize(String s, byte[] bytes) {
    try {
      JsonNode jsonNode = MAPPER.readTree(bytes);
      JsonNode afterNode = jsonNode.path("payload").path("after");
      return MAPPER.treeToValue(afterNode, GithubUserStatisticReadModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
