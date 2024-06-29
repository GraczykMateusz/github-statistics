package dev.graczykmateusz.githubstatistics.github.client;

import io.netty.channel.ChannelOption;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration(proxyBeanMethods = false)
class GithubClientConfiguration {

  @Bean("webClient")
  public WebClient webClient(@Value("${url.api.github}") String baseUrl) {
    return WebClient.builder()
        .baseUrl(baseUrl)
        .clientConnector(
            new ReactorClientHttpConnector(
                HttpClient.create()
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                    .responseTimeout(Duration.ofSeconds(5))))
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
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
    var exceptionHandler = new GithubClientExceptionHandler();
    return new GithubClientImpl(webClient, exceptionHandler);
  }
}
