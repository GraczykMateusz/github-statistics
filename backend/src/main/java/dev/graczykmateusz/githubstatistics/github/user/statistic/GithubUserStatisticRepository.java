package dev.graczykmateusz.githubstatistics.github.user.statistic;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
interface GithubUserStatisticRepository {

  @Insert(
      "INSERT INTO github_user_statistic (login, count) VALUES (#{login}, 1) "
          + "ON CONFLICT (login) DO UPDATE SET count = github_user_statistic.count + 1")
  void incrementCount(GithubUserStatisticSaveModel githubUserStatisticSaveModel);
}
