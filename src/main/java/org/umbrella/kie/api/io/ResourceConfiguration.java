package org.umbrella.kie.api.io;

import java.util.Properties;

/**
 * This interface is a marker interface and should be implemented by any class
 * that will provide configurations to the
 * {@link org.umbrella.kie.api.builder.KieBuilder} - currently this is
 * only used by decision tables.
 */
public interface ResourceConfiguration {
    public Properties toProperties();

    public ResourceConfiguration fromProperties(Properties prop);
}
