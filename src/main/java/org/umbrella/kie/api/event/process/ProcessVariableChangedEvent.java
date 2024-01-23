package org.umbrella.kie.api.event.process;

import java.util.List;

/**
 * An event when a variable inside a process instance has been changed.
 */
public interface ProcessVariableChangedEvent extends ProcessEvent{
    String getVariableId();

    String getVariableInstanceId();

    Object getOldValue();

    Object getNewvalue();

    List<String> getTags();

    boolean hasTag(String tag);
}
