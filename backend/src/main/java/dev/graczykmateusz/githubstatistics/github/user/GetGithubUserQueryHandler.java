package dev.graczykmateusz.githubstatistics.github.user;

import dev.graczykmateusz.githubstatistics.abstraction.event.EventPublisher;
import dev.graczykmateusz.githubstatistics.abstraction.query.QueryHandler;
import dev.graczykmateusz.githubstatistics.github.client.GithubClient;
import dev.graczykmateusz.githubstatistics.github.user.dto.GithubUserDto;
import dev.graczykmateusz.githubstatistics.github.user.event.GetGithubUserWasExecuted;
import dev.graczykmateusz.githubstatistics.github.user.query.GetGithubUser;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
class GetGithubUserQueryHandler implements QueryHandler<GithubUserDto, GetGithubUser> {

  private final GithubClient client;
  private final EventPublisher<GetGithubUserWasExecuted> publisher;

  @Override
  public Mono<GithubUserDto> handle(GetGithubUser query) {
    publisher.publish(new GetGithubUserWasExecuted(query.login()));
    return client.getUser(query.login()).flatMap(GithubUserMapper::toDto);
  }
}
