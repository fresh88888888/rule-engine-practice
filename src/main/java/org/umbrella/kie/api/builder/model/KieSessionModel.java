package org.umbrella.kie.api.builder.model;

import java.util.List;
import java.util.Map;

import org.umbrella.kie.api.runtime.conf.BeliefSystemTypeOption;
import org.umbrella.kie.api.runtime.conf.ClockTypeOption;

/**
 * KieSessionModel is a model allowing to programmatically define a KieSession
 * 
 * @see org.umbrella.kie.api.runtime.KieSession
 */
public interface KieSessionModel {
    String getName();

    KieSessionType getType();

    KieSessionModel setType(KieSessionType type);

    ClockTypeOption getClockType();

    KieSessionModel setClockType(ClockTypeOption clockType);

    BeliefSystemTypeOption getBeliefSystem();

    KieSessionModel setBeliefSystem(BeliefSystemTypeOption beliefSystem);

    ListenerModel newListenerModel(String type, ListenerModel.Kind kind);

    List<ListenerModel> getListenerModels();

    WorkItemHandlerModel newWorkItemHandlerModel(String name, String type);

    List<WorkItemHandlerModel> getWorkItemHandlerModels();

    ChannelModel newChannelModel(String name, String type);

    List<ChannelModel> getChannelModels();

    KieSessionModel setScope(String scope);

    String getScope();

    String getConsoleLogger();

    KieSessionModel setConsoleLogger(String consoleLogger);

    FileLoggerModel getFileLogger();

    KieSessionModel setFileLogger(String fileName);

    KieSessionModel setFileLogger(String fileName, int interval, boolean threaded);

    KieSessionModel addCalendar(String name, String type);

    Map<String, String> getCalendars();

    boolean isDefault();

    /**
     * Sets the KieSession generated from this KieSessionModel as the default one,
     * i.e. the one that can be loaded from the KieContainer without having to pass
     * its name.
     * Note that only one default KieSessionModel of type STATEFUL and one of type
     * STATELESS
     * are allowed in a given KieContainer so if more than one is found
     * (maybe because a given KieContainer includes many KieModules) a warning is
     * emitted
     * and all the defaults are disabled so all the KieSessions will be accessible
     * only by name
     */
    KieSessionModel setDefault(boolean isDefault);

    boolean isDirectFiring();

    KieSessionModel setDirectFiring(boolean isDefault);

    KieBaseModel getKieBaseModel();

    boolean isThreadSafe();

    KieSessionModel setThreadSafe(boolean threadSafe);

    boolean isAccumulateNullPropagation();

    KieSessionModel setAccumulateNullPropagation(boolean accumulateNullPropagation);

    enum KieSessionType {
        STATEFUL, STATELESS
    }
}
