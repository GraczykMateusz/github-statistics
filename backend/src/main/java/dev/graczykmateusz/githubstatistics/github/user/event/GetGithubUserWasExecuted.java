package dev.graczykmateusz.githubstatistics.github.user.event;

import dev.graczykmateusz.githubstatistics.abstraction.event.Event;

public record GetGithubUserWasExecuted(String login) implements Event {}
