package org.umbrella.kie.api.definition.rule;

import java.util.Map;

import org.umbrella.kie.api.definition.KieDefinition;

/**
 * Public Rule interface for runtime rule inspection.
 */
public interface Rule extends KieDefinition{
    String getPackageName();

    String getName();

    Map<String, Object> getMetaData();

    int getLoadOrder();
}
