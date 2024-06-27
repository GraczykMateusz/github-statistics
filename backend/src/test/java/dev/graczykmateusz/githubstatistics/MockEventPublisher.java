package dev.graczykmateusz.githubstatistics;

import dev.graczykmateusz.githubstatistics.abstraction.event.DomainEvent;
import dev.graczykmateusz.githubstatistics.abstraction.event.DomainEventPublisher;
import java.util.ArrayList;
import java.util.List;

public class MockEventPublisher<T extends DomainEvent> implements DomainEventPublisher<T> {

  private final List<T> events = new ArrayList<>();

  @Override
  public void publish(T event) {
    events.add(event);
  }

  public List<T> getEvents() {
    return events;
  }

  public void printAll() {
    events.forEach(System.out::println);
  }
}
