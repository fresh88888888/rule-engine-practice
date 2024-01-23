package org.umbrella.kie.api;

import java.util.Collection;
import java.util.Set;

import org.umbrella.kie.api.definition.KiePackage;
import org.umbrella.kie.api.definition.process.Process;
import org.umbrella.kie.api.definition.rule.Query;
import org.umbrella.kie.api.definition.rule.Rule;
import org.umbrella.kie.api.definition.type.FactType;
import org.umbrella.kie.api.runtime.Environment;
import org.umbrella.kie.api.runtime.KieSession;
import org.umbrella.kie.api.runtime.KieSessionConfiguration;
import org.umbrella.kie.api.runtime.KieSessionsPool;
import org.umbrella.kie.api.runtime.StatelessKieSession;

/**
 * <p>
 * The KieBase is a repository of all the application's knowledge definitions.
 * It will contain rules, processes, functions, type models. The KieBase itself
 * does not contain runtime data, instead sessions are created from the KieBase
 * in which
 * data can be inserted and process instances started.
 * </p>
 */
public interface KieBase {
    Collection<KiePackage> getKiePackages();

    KiePackage getKiePackage(String packageName);

    void removeKiePackage(String packageName);

    Rule getRule(String packageName, String ruleName);

    void removeRule(String packageName, String ruleName);

    Query getQuery(String packageName, String queryName);

    void removeQuery(String packageName, String queryName);

    void removeFunction(String packageName, String functionName);

    FactType getFactType(String packageName, String typeName);

    Process getProcess(String processId);

    void removeProcess(String processId);

    Collection<Process> getProcesses();

    /**
     * Creates a new {@link KieSession} using the default session configuration.
     * Don't forget to {@link KieSession#dispose()} session when you are done.
     *
     * @return created {@link KieSession}
     */
    KieSession newKieSession(KieSessionConfiguration configuration, Environment environment);

    KieSession newKieSession();

    KieSessionsPool newKieSessionsPool(int initialSize);

    Collection<? extends KieSession> getKieSessions();

    StatelessKieSession newSataStatelessKieSession(KieSessionConfiguration configuration);

    StatelessKieSession newStatelessKieSession();

    /**
     * Returns the set of the entry points declared and/or used in this kie base
     *
     * @return a Set of entry points
     */
    Set<String> getEntryPointIds();
}
