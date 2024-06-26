package dev.graczykmateusz.githubstatistics.github.client;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;

@JsonDeserialize(using = GithubUserDeserializer.class)
record GithubUser(
    Long id,
    String login,
    String name,
    String type,
    String avatarUrl,
    Instant createdAt,
    double calculations) {}
