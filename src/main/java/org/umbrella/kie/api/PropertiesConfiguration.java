package org.umbrella.kie.api;

/**
 * Base class for other Configuration classes.
 */
public interface PropertiesConfiguration {
    public void setProperty(String name, String value);

    public String getProperty(String name);
}
