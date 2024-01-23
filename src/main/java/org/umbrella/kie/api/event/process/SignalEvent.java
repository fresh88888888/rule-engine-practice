package org.umbrella.kie.api.event.process;

/**
 * An event when a signal is thrown
 */
public interface SignalEvent extends ProcessNodeEvent{
    String getSignalName();

    Object getSignal();
}
