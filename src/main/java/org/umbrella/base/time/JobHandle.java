package org.umbrella.base.time;

/**
 * An interface for Job Handles
 */
public interface JobHandle {
    long get();

    void cancel();

    boolean isCancel();
}
