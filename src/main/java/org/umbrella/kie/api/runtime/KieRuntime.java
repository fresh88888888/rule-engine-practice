package org.umbrella.kie.api.runtime;

import java.util.Map;

import org.umbrella.kie.api.KieBase;
import org.umbrella.kie.api.event.KieRuntimeEventManager;
import org.umbrella.kie.api.runtime.process.ProcessRuntime;
import org.umbrella.kie.api.runtime.rule.RuleRuntime;
import org.umbrella.kie.api.time.SessionClock;

public interface KieRuntime extends RuleRuntime, ProcessRuntime, KieRuntimeEventManager {
    /**
     * @return the session clock instance assigned to this session
     */
    <T extends SessionClock> T getSessionClock();

    void setGlobal(String identIfier, Object value);

    Object getGlobal(String identifier);

    Globals getGlobals();

    Calendars getCalendars();

    Environment getEnvironment();

    /**
     * @return the KieBase reference from which this stateful session was created.
     */
    KieBase getKieBase();

    void registerChannel(String name, Channel channel);

    void unregisterChannel(String name);

    Map<String, Channel> getChannels();

    KieSessionConfiguration getKieSessionConfiguration();
}
