package dev.graczykmateusz.githubstatistics.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync(proxyTargetClass = true)
@Configuration(proxyBeanMethods = false)
class AsyncConfiguration {}
