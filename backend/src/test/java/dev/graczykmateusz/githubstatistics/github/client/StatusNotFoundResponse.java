package dev.graczykmateusz.githubstatistics.github.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class StatusNotFoundResponse {

  // language=JSON
  public static final String JSON =
      """
    {
      "message": "Not Found",
      "documentation_url": "https://docs.github.com/rest",
      "status": "404"
    }
    """;
}
