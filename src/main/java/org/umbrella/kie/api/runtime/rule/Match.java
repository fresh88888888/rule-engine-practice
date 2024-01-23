package org.umbrella.kie.api.runtime.rule;

import java.util.List;

import org.umbrella.kie.api.definition.rule.Rule;

public interface Match {
    Rule getRule();

    List<? extends FactHandle> getFactHandles();

    List<Object> getObjects();

    List<String> getDeclaratioIds();

    Object getDeclarationValue(String declarationId);

    int getSlience();
}
