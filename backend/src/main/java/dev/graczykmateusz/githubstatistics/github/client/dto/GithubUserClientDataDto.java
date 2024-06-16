package dev.graczykmateusz.githubstatistics.github.client.dto;

import java.time.Instant;

public record GithubUserClientDataDto(
    Long id,
    String login,
    String name,
    String type,
    String avatarUrl,
    Instant createdAt,
    double calculations) {}
