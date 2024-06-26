package dev.graczykmateusz.githubstatistics.github.client.exception;

public class ZeroFollowersException extends RuntimeException {
  public ZeroFollowersException(String message) {
    super(message);
  }
}
