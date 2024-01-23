package org.umbrella.kie.api.runtime.rule;

public interface Row {
    Object get(String identifier);

    FactHandle getFactHandle(String identifier);
}
