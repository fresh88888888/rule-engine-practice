package org.umbrella.kie.api.event.kiebase;

import org.umbrella.kie.api.definition.rule.Rule;

public interface AfterKieBaseLockedEvent extends KieBaseEvent{
    Rule getRule();
}
