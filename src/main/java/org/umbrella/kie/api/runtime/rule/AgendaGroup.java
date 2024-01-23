package org.umbrella.kie.api.runtime.rule;

public interface AgendaGroup {
    /**
     * Static reference to determine the default <code>AgendaGroup</code> name.
     */
    String MAIN = "MAIN";

    String getName();

    void clear();

    void setFocus();
}
