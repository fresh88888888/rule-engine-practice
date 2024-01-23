package org.umbrella.kie.api.definition;

import java.util.Collection;

import org.apache.commons.codec.language.bm.Rule;
import org.umbrella.kie.api.definition.process.Process;
import org.umbrella.kie.api.definition.rule.Global;
import org.umbrella.kie.api.definition.rule.Query;
import org.umbrella.kie.api.definition.type.FactType;

/**
 * This provides a collection of knowledge definitions that can be given to a
 * {@link org.umbrella.kie.api.KieBase}.
 * The name is used to provide "namespace" separation of those definitions.
 */
public interface KiePackage {
    String getName();

    Collection<Rule> getRules();

    Collection<Process> getProcesses();

    Collection<FactType> getFactTypes();

    Collection<Query> getQueries();

    Collection<String> getFunctionNames();

    Collection<Global> getGlobalVariables();
}
