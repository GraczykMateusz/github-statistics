package dev.graczykmateusz.githubstatistics.github.user.statistic.dto;

import dev.graczykmateusz.githubstatistics.abstraction.query.QueryResult;

public record GithubUserStatisticDto(String login, long count) implements QueryResult {}
