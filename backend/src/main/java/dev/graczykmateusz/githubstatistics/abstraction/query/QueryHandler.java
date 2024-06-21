package dev.graczykmateusz.githubstatistics.abstraction.query;

import java.lang.reflect.ParameterizedType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QueryHandler<R extends QueryResult, Q extends Query> {

  default Class<Q> handlingCommandClass() {
    //noinspection unchecked
    return (Class<Q>)
        ((ParameterizedType) this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[1];
  }

  default Mono<R> handle(Q query) {
    return Mono.error(
        new UnsupportedOperationException("This query handler does not support single result!"));
  }

  default Flux<R> handleMany(Q query) {
    return Flux.error(
        new UnsupportedOperationException("This query handler does not support multiple results!"));
  }
}
