package dev.graczykmateusz.githubstatistics.abstraction.event;

public interface EventListener<T extends Event> {
    
    void listen(T event);
}
