package org.umbrella.kie.api.event.rule;

import org.umbrella.kie.api.definition.rule.Rule;
import org.umbrella.kie.api.runtime.rule.FactHandle;

public interface ObjectInsertedEvent extends RuleRuntimeEvent{
    FactHandle getFactHandle();

    Object getObject();

    Rule getRule();
}
