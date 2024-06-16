package dev.graczykmateusz.githubstatistics.boot;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@Configuration
class PostgresConfiguration{

  static PostgreSQLContainer<?> postgres =
      new PostgreSQLContainer<>("postgres:latest")
          .withDatabaseName("devdb")
          .withUsername("devuser")
          .withPassword("devpass")
          .withExposedPorts(5432);

  static {
    postgres.start();
  }
  
  @Bean
  public DataSource dataSource() {
    return DataSourceBuilder.create()
            .url(postgres.getJdbcUrl())
            .username(postgres.getUsername())
            .password(postgres.getPassword())
            .build();
  }
}
