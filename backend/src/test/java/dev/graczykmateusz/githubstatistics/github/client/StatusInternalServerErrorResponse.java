package dev.graczykmateusz.githubstatistics.github.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class StatusInternalServerErrorResponse {

  // language=JSON
  public static final String JSON =
      """
      {
        "message": "Internal Server Error",
        "documentation_url": "https://docs.github.com/rest",
        "status": "500"
      }
      """;
}
