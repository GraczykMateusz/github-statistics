package dev.graczykmateusz.githubstatistics.github.client.exception;

import dev.graczykmateusz.githubstatistics.abstraction.exception.GithubException;

public class GithubClientException extends GithubException {

  public GithubClientException(String message, Throwable cause) {
    super(message, cause);
  }
}
