package dev.graczykmateusz.githubstatistics.api;

import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandlerExecutor;
import dev.graczykmateusz.githubstatistics.github.user.statistic.dto.GithubUserStatisticDto;
import dev.graczykmateusz.githubstatistics.github.user.statistic.query.GetAllGithubUsersStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/users/all/statistics")
@RequiredArgsConstructor
class GithubUserStatisticsController {

  private final QueryHandlerExecutor queryHandlerExecutor;

  @GetMapping
  Flux<GithubUserStatisticDto> getAllUsersStatistics() {
    return queryHandlerExecutor.executeMany(new GetAllGithubUsersStatistics()).map(v -> (GithubUserStatisticDto) v);
  }
}
