package dev.graczykmateusz.githubstatistics.github.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration(proxyBeanMethods = false)
class GithubClientConfiguration {

  @Bean("webClient")
  public WebClient webClient(@Value("${url.api.github}") String baseUrl) {
    return WebClient.builder()
        .baseUrl(baseUrl)
        .defaultHeader("Accept", "application/json")
        .exchangeStrategies(
            ExchangeStrategies.builder()
                .codecs(
                    configurer ->
                        configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)) // 16 MB
                .build())
        .build();
  }

  @Bean("githubClient")
  GithubClient githubClient(WebClient webClient) {
    return new GithubClientImpl(webClient);
  }
}
