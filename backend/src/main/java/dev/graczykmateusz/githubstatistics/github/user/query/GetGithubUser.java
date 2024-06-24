package dev.graczykmateusz.githubstatistics.github.user.query;

import dev.graczykmateusz.githubstatistics.abstraction.query.Query;

public record GetGithubUser(String login) implements Query {

  public String login() {
    return login.toLowerCase();
  }
}
