package dev.graczykmateusz.githubstatistics.github.user.statistic;

import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandler;
import dev.graczykmateusz.githubstatistics.github.user.statistic.dto.GithubUserStatisticDto;
import dev.graczykmateusz.githubstatistics.github.user.statistic.query.GetAllGithubUsersStatistics;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
class GetAllGithubUserStatisticQueryHandler
    implements QueryHandler<GithubUserStatisticDto, GetAllGithubUsersStatistics> {

  private final GithubUserStatisticQueryRepository queryRepository;

  @Override
  public Flux<GithubUserStatisticDto> handleMany(GetAllGithubUsersStatistics query) {
    return Flux.fromIterable(
        queryRepository.findAll().stream().map(GithubUserStatisticMapper::toDto).toList());
  }
}
