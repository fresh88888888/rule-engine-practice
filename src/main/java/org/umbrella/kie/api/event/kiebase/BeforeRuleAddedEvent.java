package org.umbrella.kie.api.event.kiebase;

import org.umbrella.kie.api.definition.rule.Rule;

public interface BeforeRuleAddedEvent extends KieBaseEvent{
    Rule getRule();
}
