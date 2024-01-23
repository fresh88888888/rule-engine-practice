package org.umbrella.kie.api.event.kiebase;

import org.umbrella.kie.api.definition.process.Process;

public interface AfterProcessRemovedEvent extends KieBaseEvent{
    Process getProcess();
}
