package org.umbrella.base.rule.constraint;

import org.umbrella.base.base.ValueResolver;
import org.umbrella.kie.api.runtime.rule.FactHandle;

public interface AlphaNodeFieldConstraint extends Constraint{
    boolean isAllowed(FactHandle handle, ValueResolver valueResolver);
    
    /**
     * Clone this constraints only if it is already used by a different node,
     * otherwise returns this
     */
    AlphaNodeFieldConstraint cloneIfInUse();
}
