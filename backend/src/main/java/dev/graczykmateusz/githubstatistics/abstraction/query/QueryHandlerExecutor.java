package dev.graczykmateusz.githubstatistics.abstraction.query;

import reactor.core.publisher.Mono;

public interface QueryHandlerExecutor {

  Mono<QueryResult> execute(Query query);
}
