package org.umbrella.kie.api.event.kiebase;

import org.umbrella.kie.api.definition.process.Process;

public interface AfterProcessAddedEvent extends KieBaseEvent{
    Process getProcess();
}
