package org.umbrella.kie.api.definition.process;

import java.util.Map;

/**
 * A connection is a link from one Node to another.
 */
public interface Connection {
    Node getFrom();

    Node getTo();

    String getFromType();

    String getToType();

    Map<String, Object> getMetaDate();
}
