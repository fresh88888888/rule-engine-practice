package org.umbrella.kie.api.event.rule;

import org.umbrella.kie.api.event.KieRuntimeEvent;
import org.umbrella.kie.api.runtime.rule.Match;

public interface MatchEvent extends KieRuntimeEvent{
    public Match geMatch();
}
