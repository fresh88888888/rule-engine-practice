package org.umbrella.kie.api.event.rule;

public interface MatchCancelledEvent extends MatchEvent{
    MatchCancelledCause getCause();
}
