package dev.graczykmateusz.githubstatistics.handler;

import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandler;
import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandlerExecutor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class HandlersConfiguration {

  @Bean("queryHandlerExecutor")
  @SuppressWarnings({"rawtypes"})
  public QueryHandlerExecutor queryHandlerExecutor(
      @Autowired(required = false) List<QueryHandler> queryHandlers) {
    return new QueryHandlerExecutorImpl(queryHandlers);
  }
}
