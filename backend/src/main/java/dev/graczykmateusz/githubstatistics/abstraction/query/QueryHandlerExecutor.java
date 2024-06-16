package dev.graczykmateusz.githubstatistics.abstraction.query;

public interface QueryHandlerExecutor {

  QueryResult execute(Query query);
}
