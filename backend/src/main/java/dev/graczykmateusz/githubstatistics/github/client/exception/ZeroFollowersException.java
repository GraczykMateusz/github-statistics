package dev.graczykmateusz.githubstatistics.github.client.exception;

import dev.graczykmateusz.githubstatistics.abstraction.exception.GithubException;

public class ZeroFollowersException extends GithubException {

  public ZeroFollowersException(String message) {
    super(message);
  }
}
