package org.umbrella.kie.api.definition.rule;

import java.util.Map;

import org.umbrella.kie.api.definition.KieDefinition;

public interface Query extends KieDefinition{
    String getName();

    String getPackageName();

    Map<String, Object> getMetaData();
}
