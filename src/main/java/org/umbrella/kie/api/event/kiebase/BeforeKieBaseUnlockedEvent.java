package org.umbrella.kie.api.event.kiebase;

import org.umbrella.kie.api.KieBase;

public interface BeforeKieBaseUnlockedEvent extends KieBaseEvent{
    KieBase getKieBase();
}
