package org.umbrella.kie.api.event.rule;

import org.umbrella.kie.api.definition.rule.Rule;
import org.umbrella.kie.api.runtime.rule.FactHandle;

public interface ObjectUpdatedEvent extends RuleRuntimeEvent{
    public FactHandle getFactHandle();

    public Object getOldObject();

    public Object getObject();

    public Rule getRule();
}
