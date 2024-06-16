package dev.graczykmateusz.githubstatistics.abstraction.query;

import java.lang.reflect.ParameterizedType;
import reactor.core.publisher.Mono;

public interface QueryHandler<R extends QueryResult, Q extends Query> {

  default Class<Q> handlingCommandClass() {
    //noinspection unchecked
    return (Class<Q>)
        ((ParameterizedType) this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[1];
  }

  Mono<R> handle(Q query);
}
