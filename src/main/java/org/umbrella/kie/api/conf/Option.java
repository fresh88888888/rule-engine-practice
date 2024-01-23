package org.umbrella.kie.api.conf;

import java.io.Serializable;

/**
 * A base interface for type safe options in configuration objects
 */
public interface Option extends Serializable{
    String type();
}
