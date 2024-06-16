package dev.graczykmateusz.githubstatistics.github.user.event;

import dev.graczykmateusz.githubstatistics.abstraction.event.DomainEvent;

public record GetGithubUserWasExecuted(String login) implements DomainEvent {}
