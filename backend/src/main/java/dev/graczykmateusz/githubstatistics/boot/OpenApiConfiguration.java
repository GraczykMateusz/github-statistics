package dev.graczykmateusz.githubstatistics.boot;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class OpenApiConfiguration {

  @Bean("publicApi")
  GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder().group("api").pathsToMatch("/**").build();
  }
}
