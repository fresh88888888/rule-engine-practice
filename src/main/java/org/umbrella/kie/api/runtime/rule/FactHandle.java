package org.umbrella.kie.api.runtime.rule;

/**
 * An handle to a fact inserted into the work memory
 */
public interface FactHandle {

    Object getObject();

    boolean isNegated();

    boolean isEvent();

    long getId();

    long getRecency();

    <K> K as(Class<K> kClass) throws ClassCastException;

    boolean isValid();

    String toExternalFrom();

    enum State {
        ALL,
        STATED,
        LOGICAL;

        public boolean isStated() {
            return this != LOGICAL;
        }

        public boolean isLogical() {
            return this != STATED;
        }
    }

}
