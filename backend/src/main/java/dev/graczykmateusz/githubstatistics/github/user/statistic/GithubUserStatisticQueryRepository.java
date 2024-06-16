package dev.graczykmateusz.githubstatistics.github.user.statistic;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
interface GithubUserStatisticQueryRepository {

  @Select("SELECT * FROM github_user_statistic")
  List<GithubUserStatisticReadModel> findAll();
}
