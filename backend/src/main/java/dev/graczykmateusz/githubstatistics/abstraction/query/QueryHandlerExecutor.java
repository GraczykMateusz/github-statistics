package dev.graczykmateusz.githubstatistics.abstraction.query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QueryHandlerExecutor {

  Mono<QueryResult> execute(Query query);

  Flux<QueryResult> executeMany(Query query);
}
