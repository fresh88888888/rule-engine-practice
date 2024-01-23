package org.umbrella.kie.api.event.process;

import java.util.Collection;

/**
 * A manager for process related events.
 */
public interface ProcessEventManager {
    public void addEventListener(ProcessEventListener listener);

    public void removeEventListener(ProcessEventListener listener);

    public Collection<ProcessEventListener> getProcessEventListeners();
}
