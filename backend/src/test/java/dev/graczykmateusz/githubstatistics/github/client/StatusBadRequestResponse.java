package dev.graczykmateusz.githubstatistics.github.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class StatusBadRequestResponse {

  // language=JSON
  public static final String JSON =
      """
       {
         "message": "Bad Request",
         "documentation_url": "https://docs.github.com/rest",
         "status": "400"
       }
       """;
}
