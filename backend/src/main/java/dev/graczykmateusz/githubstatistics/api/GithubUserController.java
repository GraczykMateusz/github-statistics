package dev.graczykmateusz.githubstatistics.api;

import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandlerExecutor;
import dev.graczykmateusz.githubstatistics.abstraction.query.QueryResult;
import dev.graczykmateusz.githubstatistics.github.user.query.GetGithubUser;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
class GithubUserController {

  private final QueryHandlerExecutor queryHandlerExecutor;

  @GetMapping("/{login}")
  Mono<QueryResult> getUserData(@PathVariable("login") String login) {
    return queryHandlerExecutor.execute(new GetGithubUser(login));
  }
  
//  @MessageMapping("/github")
//  @SendTo("/topic/db-updates")
//  public String handleWebSocketRequest(String message) {
//    System.out.println("dupa");
//    return message; // Echo back the message to subscribers
//  }

  @GetMapping("/a/a")
  String a() {
    return "{\"x\": \"x\"}";
  }
}
