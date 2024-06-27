package dev.graczykmateusz.githubstatistics.github.client.exception;

import dev.graczykmateusz.githubstatistics.abstraction.exception.GithubException;

public class GithubUserNotFoundException extends GithubException {

  public GithubUserNotFoundException(String login, Throwable e) {
    super("Github user with login: " + login + " not found!", e);
  }
}
