package org.umbrella.kie.api.runtime.process;

/**
 * A work item handler is responsible for executing work items
 * of a specific type. They represent the glue code between an
 * abstract, high-level work item that is used inside the process
 * and the implementation of this work item. Work item handlers
 * should be registered with the <code>WorkItemManager</code> for
 * each type of work that can be executed in the engine.
 *
 * A work item handler is responsible for executing a work item whenever
 * the work item manager delegates one to it. It should also notify
 * the work item manager when the work item has been completed.
 *
 * It is also possible that a work item handler is requested to abort
 * an existing work item (that is still executing) because it is no longer
 * necessary. This might for example be because the process instance
 * (or a part of the process instance) that is was executing in is being
 * aborted. The work item handler should then try to abort this work item
 * (if possible) and if necessary clean up runtime state related to its
 * execution.
 *
 * For example, a work item handler that is responsible for executing
 * email work items will retrieve the necessary information from the
 * work item (from, to, body, etc.) and invoke the mail server. Afterwards,
 * it will notify the <code>WorkItemManager</code> that the work item was
 * completed.
 */
public interface WorkItemHandler {

    /**
     * The given work item should be executed.
     * 
     * @param workItem the work item that should be executed
     * @param manager  the manager that requested the work item to be executed
     */
    void executeWorkItem(WorkItem item, WorkItemManager manager);
    
    /**
     * The given work item should be aborted.
     * 
     * @param workItem the work item that should be aborted
     * @param manager  the manager that requested the work item to be aborted
     */
    void abortWorkItem(WorkItem item, WorkItemManager manager);
}
