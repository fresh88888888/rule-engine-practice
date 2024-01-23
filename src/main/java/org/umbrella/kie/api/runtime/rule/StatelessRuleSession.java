package org.umbrella.kie.api.runtime.rule;

public interface StatelessRuleSession {
    /**
     * Execute a StatelessKieSession inserting just a single object. If a collection
     * (or any other Iterable) or an array is used here, it will be inserted as-is,
     * It will not be iterated and its internal elements inserted.
     *
     * @param object
     */
    void execute(Object object);

    /**
     * Execute a StatelessKieSession, iterate the Iterable inserting each of its
     * elements. If you have an array, use the Arrays.asList(...) method
     * to make that array Iterable.
     * 
     * @param objects
     */
    void execute(Iterable objects);
}
