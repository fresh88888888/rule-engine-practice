package org.umbrella.kie.api.event.kiebase;

import org.umbrella.kie.api.definition.rule.Rule;

public interface AfterRuleRemovedEvent extends KieBaseEvent{
    Rule getRule();
}
