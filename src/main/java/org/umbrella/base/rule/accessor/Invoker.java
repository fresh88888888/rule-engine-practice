package org.umbrella.base.rule.accessor;

import org.umbrella.base.rule.RuleComponent;

public interface Invoker extends RuleComponent {
    default boolean wrapsCompiledInvoker() {
        return false;
    }
}
