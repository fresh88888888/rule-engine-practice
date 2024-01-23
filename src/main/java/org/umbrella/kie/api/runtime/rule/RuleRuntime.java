package org.umbrella.kie.api.runtime.rule;

import java.util.Collection;

public interface RuleRuntime extends EntryPoint {
    /**
     * <p>
     * Request the engine to stop firing rules. If the engine is currently firing a
     * rule, it will
     * finish executing this rule's consequence before stopping.
     * </p>
     * <p>
     * This method will not remove active Matches from the Agenda.
     * In case the application later wants to continue firing rules from the point
     * where it stopped,
     * it should just call
     * <code>org.kie.api.runtime.KieSession#fireAllRules()</code> or
     * <code>org.kie.api.runtime.KieSession#fireUntilHalt()</code> again.
     * </p>
     */
    void halt();

    Agenda getAgenda();

    EntryPoint getEntryPoint(String name);

    Collection<? extends EntryPoint> getEntryPoints();

    QueryResults getQueryResults(String query, Object... arguments);

    LiveQuery openLiveQuery(String query, Object[] arguments, ViewChangedEventListener listener);

}
