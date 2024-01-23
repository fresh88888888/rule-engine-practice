package org.umbrella.base.rule.constraint;

import org.umbrella.base.rule.ContextEntry;
import org.umbrella.kie.api.runtime.rule.FactHandle;

public interface BetaNodeFieldConstraint extends Constraint{
    boolean isAllowedCachedLeft(ContextEntry entry, FactHandle handle);

    boolean isAllowedCachedRight(ContextEntry entry, FactHandle handle);

    ContextEntry createContextEntry();
    
    /**
     * Clone this constraints only if it is already used by a different node,
     * otherwise returns this
     */
    BetaNodeFieldConstraint cloneIfInUse();
}
