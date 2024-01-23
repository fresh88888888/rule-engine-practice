package org.umbrella.kie.api.event.rule;

import org.umbrella.kie.api.event.KieRuntimeEvent;
import org.umbrella.kie.api.runtime.rule.RuleFlowGroup;

public interface RuleFlowGroupEvent extends KieRuntimeEvent {
    /**
     * The RuleFlowGroup for this event
     *
     * @return the RuleFlowGroup for this event
     */
    RuleFlowGroup getRuleFlowGroup();
}
