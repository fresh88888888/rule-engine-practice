package org.umbrella.kie.api.event.kiebase;

import java.util.Collection;

public interface KieBaseEventManager {
    void addEventListener(KieBaseEventListener listener);

    void removeEventListener(KieBaseEventListener listener);

    Collection<KieBaseEventListener> getKieBaseEventListeners();
}
