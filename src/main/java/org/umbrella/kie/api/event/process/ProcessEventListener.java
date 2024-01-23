package org.umbrella.kie.api.event.process;

import java.util.EventListener;

/**
 * A listener for events related to process instance execution.
 */
public interface ProcessEventListener extends EventListener {
    void beforeProcessStarted(ProcessStartedEvent event);

    void afterProcessStarted(ProcessStartedEvent event);

    void beforeProcessCompleted(ProcessCompletedEvent event);

    void afterProcessCompleted(ProcessCompletedEvent event);

    void beforeNodeTriggered(ProcessNodeEvent event);

    void afterNodeTriggered(ProcessNodeEvent event);

    void beforeNodeLeft(ProcessNodeLeftEvent event);

    void afterNodeLeft(ProcessNodeLeftEvent event);

    void beforeVariableChanged(ProcessVariableChangedEvent event);

    void afterVariableChanged(ProcessVariableChangedEvent event);

    default void beforeSLAViolated(SLAViolatedEvent event) {
    }

    default void afterSLAViolated(SLAViolatedEvent event) {
    }

    default void onSignal(SignalEvent event) {
    }

    default void onMessage(MessageEvent event) {
    }
}
