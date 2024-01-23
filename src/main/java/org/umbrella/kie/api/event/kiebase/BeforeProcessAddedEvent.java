package org.umbrella.kie.api.event.kiebase;

import org.umbrella.kie.api.definition.process.Process;

public interface BeforeProcessAddedEvent extends KieBaseEvent{
    Process getProcess();
}
