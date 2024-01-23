package org.umbrella.kie.api.event.kiebase;

import org.umbrella.kie.api.definition.KiePackage;

public interface BeforeKiePackageRemovedEvent extends KieBaseEvent{
    KiePackage getKiePackage();
}
