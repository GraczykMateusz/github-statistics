package dev.graczykmateusz.githubstatistics.github.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class GithubResponse {

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  static class Ok {

    // language=JSON
    public static final String JSON =
        """
          {
            "login": "GraczykMateusz",
            "id": 43554417,
            "node_id": "MDQ6VXNlcjQzNTU0NDE3",
            "avatar_url": "https://avatars.githubusercontent.com/u/43554417?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/GraczykMateusz",
            "html_url": "https://github.com/GraczykMateusz",
            "followers_url": "https://api.github.com/users/GraczykMateusz/followers",
            "following_url": "https://api.github.com/users/GraczykMateusz/following{/other_user}",
            "gists_url": "https://api.github.com/users/GraczykMateusz/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/GraczykMateusz/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/GraczykMateusz/subscriptions",
            "organizations_url": "https://api.github.com/users/GraczykMateusz/orgs",
            "repos_url": "https://api.github.com/users/GraczykMateusz/repos",
            "events_url": "https://api.github.com/users/GraczykMateusz/events{/privacy}",
            "received_events_url": "https://api.github.com/users/GraczykMateusz/received_events",
            "type": "User",
            "site_admin": false,
            "name": "Mateusz Graczyk",
            "company": null,
            "blog": "",
            "location": "Poland",
            "email": null,
            "hireable": null,
            "bio": null,
            "twitter_username": null,
            "public_repos": 18,
            "public_gists": 0,
            "followers": 6,
            "following": 6,
            "created_at": "2018-09-24T20:41:09Z",
            "updated_at": "2024-06-12T20:29:31Z"
          }
          """;
  }

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  static class BadRequest {

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

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  static class InternalServerError {

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

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  class NotFound {

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
}
