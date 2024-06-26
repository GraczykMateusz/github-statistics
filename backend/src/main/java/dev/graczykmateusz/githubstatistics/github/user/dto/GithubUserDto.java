package dev.graczykmateusz.githubstatistics.github.user.dto;

import dev.graczykmateusz.githubstatistics.abstraction.query.QueryResult;
import java.time.Instant;

public record GithubUserDto(
    Long id,
    String login,
    String name,
    String type,
    String avatarUrl,
    Instant createdAt,
    double calculations)
    implements QueryResult {}
