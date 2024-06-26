package dev.graczykmateusz.githubstatistics.api;

import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandlerExecutor;
import dev.graczykmateusz.githubstatistics.github.user.dto.GithubUserDto;
import dev.graczykmateusz.githubstatistics.github.user.query.GetGithubUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
class GithubUserController {

  private final QueryHandlerExecutor queryHandlerExecutor;

  @GetMapping("/{login}")
  Mono<GithubUserDto> getUserData(@PathVariable("login") String login) {
    return queryHandlerExecutor.execute(new GetGithubUser(login)).map(v -> (GithubUserDto) v);
  }
}
