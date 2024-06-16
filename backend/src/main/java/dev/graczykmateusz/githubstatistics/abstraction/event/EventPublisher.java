package dev.graczykmateusz.githubstatistics.abstraction.event;

public interface EventPublisher<T extends Event> {

  void publish(T event);
}
