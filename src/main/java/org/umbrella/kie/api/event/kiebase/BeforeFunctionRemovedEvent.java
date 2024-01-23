package org.umbrella.kie.api.event.kiebase;

public interface BeforeFunctionRemovedEvent extends KieBaseEvent{
    String getFunction();
}
