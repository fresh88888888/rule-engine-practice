package org.umbrella.base.base;

import org.umbrella.base.RuleBase;
import org.umbrella.base.rule.accessor.GlobalResolver;

public interface ValueResolver {

    default Object getGlobal(String identifier) {
        return getGlobalResolver().resolveGlobal(identifier);
    }

    long getCurrentTime();

    GlobalResolver getGlobalResolver();

    RuleBase getRuleBase();
}
