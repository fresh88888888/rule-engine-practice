package org.umbrella.kie.api.runtime.rule;

import java.util.Collection;

import org.umbrella.kie.api.runtime.ObjectFilter;

/**
 * <p>
 * An entry-point is an abstract channel through where facts are inserted into
 * the engine.
 * </p>
 * <p>
 * KIE 6 supports multiple entry-points into a single
 * {@link org.umbrella.kie.api.KieBase}: the
 * default, anonymous entry-point, as well as as many user declared entry points
 * the application
 * requires.
 * </p>
 *
 * <p>
 * To get a reference to an entry point, just request the session:
 * </p>
 * 
 * <pre>
 * KieSession session = kbase.newStatelessKieSession();
 * ...
 * WorkingMemoryEntryPoint entrypoint = session.getEntryPoint("my entry point");
 * </pre>
 * <p>
 * Once a reference to an entry point is acquired, the application can insert,
 * update and retract facts
 * to/from that entry-point as usual:
 * </p>
 * 
 * <pre>
 * ...
 * FactHandle factHandle = entrypoint.insert( fact );
 * ...
 * entrypoint.update( factHandle, newFact );
 * ...
 * entrypoint.retract( factHandle );
 * ...
 * </pre>
 */
public interface EntryPoint {
    String getEntryPointId();

    FactHandle insert(Object object);

    void retract(FactHandle handle);

    void delete(FactHandle handle);

    void delete(FactHandle handle, FactHandle.State fhState);

    void update(FactHandle handle, Object object);

    void update(FactHandle handle, Object object, String... modifiedProperties);

    FactHandle getFactHandle(Object object);

    Object getObject(FactHandle handle);

    Collection<? extends Object> getObjects();

    Collection<? extends Object> getObjects(ObjectFilter filter);

    <T extends FactHandle> Collection<T> getFactHandles();

    long getFactCount();
}
