package org.umbrella.kie.api.event.kiebase;

import java.util.EventListener;

public interface KieBaseEventListener extends EventListener{
    void beforeKiePackageAdded(BeforeKiePackageAddedEvent event);

    void afterKiePackageAdded(AfterKiePackageAddedEvent event);

    void beforeKiePackageRemoved(BeforeKiePackageRemovedEvent event);

    void afterKiePackageRemoved(AfterKiePackageRemovedEvent event);

    void beforeKieBaseLocked(BeforeKieBaseLockedEvent event);

    void afterKieBaseLocked(AfterKieBaseLockedEvent event);

    void beforeKieBaseUnlocked(BeforeKieBaseUnlockedEvent event);

    void afterKieBaseUnlocked(AfterKieBaseUnlockedEvent event);

    void beforeRuleAdded(BeforeRuleAddedEvent event);

    void afterRuleAdded(AfterRuleAddedEvent event);

    void beforeRuleRemoved(BeforeRuleRemovedEvent event);

    void afterRuleRemoved(AfterRuleRemovedEvent event);

    void beforeFunctionRemoved(BeforeFunctionRemovedEvent event);

    void afterFunctionRemoved(AfterFunctionRemovedEvent event);

    void beforeProcessAdded(BeforeProcessAddedEvent event);

    void afterProcessAdded(AfterProcessAddedEvent event);

    void beforeProcessRemoved(BeforeProcessRemovedEvent event);

    void afterProcessRemoved(AfterProcessRemovedEvent event);

}
