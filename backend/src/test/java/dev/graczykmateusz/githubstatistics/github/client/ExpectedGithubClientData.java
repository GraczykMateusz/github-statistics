package dev.graczykmateusz.githubstatistics.github.client;

import dev.graczykmateusz.githubstatistics.github.client.dto.GithubUserClientDataDto;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ExpectedGithubClientData {

  public static final GithubUserClientDataDto DATA =
      new GithubUserClientDataDto(
          43554417L,
          "GraczykMateusz",
          "Mateusz Graczyk",
          "User",
          "https://avatars.githubusercontent.com/u/43554417?v=4",
          Instant.parse("2018-09-24T20:41:09Z"),
          20.0);
}
