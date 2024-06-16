package dev.graczykmateusz.githubstatistics.abstraction.event;

public interface DomainEventPublisher<T extends DomainEvent> {

  void publish(T event);
}
