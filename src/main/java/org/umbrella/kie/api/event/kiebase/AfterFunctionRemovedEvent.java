package org.umbrella.kie.api.event.kiebase;

public interface AfterFunctionRemovedEvent extends KieBaseEvent{
    String getFunction();
}
