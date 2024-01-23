package org.umbrella.kie.api.runtime.rule;

public interface Agenda {
    public void clear();

    AgendaGroup getAgendaGroup(String name);

    ActivationGroup geActivationGroup(String name);

    RuleFlowGroup getRuleFlowGroup(String name);
}
