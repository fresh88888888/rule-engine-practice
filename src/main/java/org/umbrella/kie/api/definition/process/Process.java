package org.umbrella.kie.api.definition.process;

import java.util.Map;

import org.umbrella.kie.api.definition.KieDefinition;
import org.umbrella.kie.api.io.Resource;

/**
 * A Process represents one modular piece of business logic that can be executed
 * by
 * a process engine. Different types of processes may exist.
 *
 */
public interface Process extends KieDefinition{
    String getId();

    String getName();

    String getVersion();

    String getPackageName();

    String getType();

    Map<String, Object> getMetaData();

    Resource getResource();

    void setResource(Resource res);
}
