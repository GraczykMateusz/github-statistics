package dev.graczykmateusz.githubstatistics.api;

import dev.graczykmateusz.githubstatistics.abstraction.exception.GithubException;
import dev.graczykmateusz.githubstatistics.github.client.exception.GithubUserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
class ExceptionAdviceController {

  @ExceptionHandler(GithubUserNotFoundException.class)
  ResponseEntity<String> handleNotFoundException(GithubUserNotFoundException e) {
    return getErrorMessage(e, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(GithubException.class)
  ResponseEntity<String> handleGithubException(GithubException e) {
    return getErrorMessage(e, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<String> getErrorMessage(Exception e, HttpStatus httpStatus) {
    String error = e.toString();
    log.error(error);
    return ResponseEntity.status(httpStatus).body(e.getMessage());
  }
}
