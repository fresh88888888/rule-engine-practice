package org.umbrella.kie.api.event.kiebase;

import org.umbrella.kie.api.definition.KiePackage;

public interface AfterKiePackageRemovedEvent extends KieBaseEvent{
    public KiePackage getKiePackage();
}
