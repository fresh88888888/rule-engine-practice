package org.umbrella.kie.api.event.rule;

import java.util.Collection;

public interface RuleRuntimeEventManager {
    void addEventListener(RuleRuntimeEventListener listener);

    void removeEventListener(RuleRuntimeEventListener listener);

    Collection<RuleRuntimeEventListener> getRuleRuntimeEventListeners();

    void addEventListener(AgendaEventListener listener);

    void removeEventListener(AgendaEventListener listener);

    Collection<AgendaEventListener> getAgendaEventListeners();
}
