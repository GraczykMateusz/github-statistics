package dev.graczykmateusz.githubstatistics.boot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.graczykmateusz.githubstatistics.github.user.statistic.dto.GithubUserStatisticDto;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;

public class GithubUserStatisticKafkaDeserializer implements Deserializer<GithubUserStatisticDto> {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  @Override
  public GithubUserStatisticDto deserialize(String topic, byte[] data) {
    try {
      JsonNode jsonNode = MAPPER.readTree(data);
      JsonNode afterNode = jsonNode.path("payload").path("after");
      return MAPPER.treeToValue(afterNode, GithubUserStatisticDto.class);
    } catch (Exception e) {
      throw new DeserializationException(
          "Error when deserializing byte[] to GithubUserStatisticDto", data, false, e);
    }
  }
}
