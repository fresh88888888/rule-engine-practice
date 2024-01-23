package org.umbrella.kie.api.event.process;

import org.umbrella.kie.api.runtime.process.NodeInstance;

public interface SLAViolatedEvent extends ProcessEvent{
    NodeInstance getNodeInstance();
}
