package org.umbrella.kie.api.builder.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.umbrella.kie.api.conf.BetaRangeIndexOption;
import org.umbrella.kie.api.conf.DeclarativeAgendaOption;
import org.umbrella.kie.api.conf.EqualityBehaviorOption;
import org.umbrella.kie.api.conf.EventProcessingOption;
import org.umbrella.kie.api.conf.KieBaseMutabilityOption;
import org.umbrella.kie.api.conf.SequentialOption;
import org.umbrella.kie.api.conf.SessionsPoolOption;

/**
 * KieBaseModel is a model allowing to programmatically define a KieBase
 * 
 * @see org.umbrella.kie.api.KieBase
 */
public interface KieBaseModel {
    /**
     * Creates a new KieSessionModel with the given name and adds it to this
     * KieBaseModel
     * 
     * @param name The name of the new KieSessionModel to be created
     * @return The new KieSessionModel
     */
    KieSessionModel newKieSessionModel(String name);

    KieBaseModel removeKieSessionModel(String name);

    /**
     * Returns all the KieSessionModel defined in this KieBaseModel mapped by their
     * names
     */
    Map<String, KieSessionModel> getKieSessionModels();

    /**
     * Includes the resources of the KieBase with the given name in this
     * KieBaseModel
     */
    KieBaseModel addInclude(String kBaseName);

    /**
     * Remove the inclusion of the KieBase with the given name
     */
    KieBaseModel removeKieBaseModel(String kBaseName);

    String getName();

    /**
     * Returns the ordered list of all the package patterns used to define the set
     * of resources that have
     * to be included in the KieBase. If this list is empty, "*" is assumed by
     * default, meaning that
     * all the resources stored under a folder with the same name of this
     * KieBaseModel will be
     * included in the compiled KieBase regardless of the package they belong to.
     *
     * The list of package patterns is ordered and earlier patterns are applied
     * before later patterns.
     * For example, if you specify "org.foo.*,!org.foo.impl" the second pattern has
     * no effect since all org.foo
     * packages have already been selected by the first pattern. Instead, you should
     * specify "!org.foo.impl,org.foo.*",
     * which will export all org.foo packages except org.foo.impl.
     */
    List<String> getPackages();

    /**
     * Returns all KieBases included by this one
     */
    Set<String> getIncludes();

    KieBaseModel addPackage(String pkg);

    KieBaseModel removePackage(String pkg);

    /**
     * Returns the EqualityBehavior of this KieBaseModel
     */
    EqualityBehaviorOption getEqualBehavior();

    /**
     * Sets the EqualityBehavior for this KieBaseModel.
     * Default is EqualityBehaviorOption.IDENTITY
     */
    KieBaseModel setEqualBehavior(EqualityBehaviorOption equalsBehaviour);

    /**
     * Returns the KieBaseMutabilityOption of this KieBaseModel
     */
    KieBaseMutabilityOption getMutability();

    /**
     * Sets the KieBaseMutabilityOption for this KieBaseModel.
     * Default is KieBaseMutabilityOption.ALLOWED
     */
    KieBaseModel setMutability(KieBaseMutabilityOption mutability);

    /**
     * Returns the session pool configuration of this KieBaseModel
     */
    SessionsPoolOption getSessionsPool();

    /**
     * Sets the SessionPoolOption used by the KieBase to create new sessions
     * Default is SessionPoolOption.NO
     */
    KieBaseModel setSessionsPool(SessionsPoolOption sessionsPool);

    /**
     * Returns the EventProcessingMode of this KieBaseModel
     */
    EventProcessingOption getEventProcessingMode();

    KieBaseModel setEventProcessingMode(EventProcessingOption option);

    DeclarativeAgendaOption getDeclarativeAgenda();

    KieBaseModel setDeclarativeAgenda(DeclarativeAgendaOption option);

    BetaRangeIndexOption getBetaRangeIndexOption();

    KieBaseModel setBetaRangeIndexOption(BetaRangeIndexOption option);

    SequentialOption getSequential();

    KieBaseModel setSequential(SequentialOption option);

    KieBaseModel setScope(String scope);

    String getScope();

    List<RuleTemplateModel> getRuleTemplates();

    KieBaseModel addRuleTemplate(String dtable, String template, String row, String col);

    boolean isDefault();

    /**
     * Sets the KieBase generated from this KieBaseModel as the default one,
     * i.e. the one that can be loaded from the KieContainer without having to pass
     * its name.
     * Note that only one default KieBaseModel is allowed in a given KieContainer so
     * if more than
     * one is found (maybe because a given KieContainer includes many KieModules) a
     * warning is emitted
     * and all the defaults are disabled so all the KieBases will be accessible only
     * by name
     */
    KieBaseModel setDefault(boolean isDefault);
}
