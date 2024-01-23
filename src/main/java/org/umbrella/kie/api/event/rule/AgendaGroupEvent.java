package org.umbrella.kie.api.event.rule;

import org.umbrella.kie.api.event.KieRuntimeEvent;
import org.umbrella.kie.api.runtime.rule.AgendaGroup;

public interface AgendaGroupEvent extends KieRuntimeEvent{
    public AgendaGroup getAgendaGroup();
}
