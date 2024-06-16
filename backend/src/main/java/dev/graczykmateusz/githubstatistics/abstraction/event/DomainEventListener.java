package dev.graczykmateusz.githubstatistics.abstraction.event;

public interface DomainEventListener<T extends DomainEvent> {
    
    void listen(T event);
}
