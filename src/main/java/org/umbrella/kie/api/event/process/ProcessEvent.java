package org.umbrella.kie.api.event.process;


import java.util.Date;

import org.umbrella.kie.api.event.KieRuntimeEvent;
import org.umbrella.kie.api.runtime.process.ProcessInstance;

/**
 * A runtime event related to the execution of process instances.
 */
public interface ProcessEvent extends KieRuntimeEvent{
    ProcessInstance getProcessInstance();

    Date getEvenDate();

    default String getEventIdentity() {
        return null;
    }
}
