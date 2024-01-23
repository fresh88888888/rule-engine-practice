package org.umbrella.kie.api.runtime;

/**
 * ObjectFilter is used with WorkingMemories to filter out instances during
 * Iteration
 */
public interface ObjectFilter {
    boolean accept(Object object);
}
