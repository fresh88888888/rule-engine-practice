package org.umbrella.kie.api.runtime.process;

import org.umbrella.kie.api.definition.process.Process;

/**
 * A process instance represents one specific instance of a process
 * that is currently executing. Whenever a process is started, a
 * process instance is created that represents that specific instance
 * that was started. It contains all runtime information related to
 * that instance. Multiple process instances of the same process
 * can be executed simultaneously.
 *
 * For example, consider a process definition that describes how to
 * process a purchase order. Whenever a new purchase order comes in,
 * a new process instance will be created for that purchase order.
 * Multiple process instances (one for each purchase order) can coexist.
 *
 * A process instance is uniquely identified by an id.
 *
 * This class can be extended to represent one specific type of process,
 * e.g. <code>WorkflowProcessInstance</code> when using a
 * <code>WorkflowProcess</code>
 * where the process logic is expressed as a flow chart.
 *
 * @see org.umbrella.kie.api.runtime.process.WorkflowProcessInstance
 */
public interface ProcessInstance extends EventListener{
    int STATE_PENDING = 0;
    int STATE_ACTIVE = 1;
    int STATE_COMPLETED = 2;
    int STATE_ABORTED = 3;
    int STATE_SUSPENDED = 4;

    int SLA_NA = 0;
    int SLA_PENDING = 1;
    int SLA_MET = 2;
    int SLA_VIOLATED = 3;
    int SLA_ABORTED = 4;

    String getProcessId();

    Process getProcess();

    String getId();

    String getProcessName();

    int getState();

    String getParentProcessInstanceId();
}
