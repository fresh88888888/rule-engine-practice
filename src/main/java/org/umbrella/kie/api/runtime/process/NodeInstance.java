package org.umbrella.kie.api.runtime.process;

import org.umbrella.kie.api.definition.process.Node;

/**
 * A node instance represents the execution of one specific node
 * in a process instance. Whenever a node is reached during the
 * execution of a process instance, a node instance will be created.
 * A node instance contains all the runtime state related to the
 * execution of that node.
 * Multiple node instances for the same node can coexist in the same
 * process instance (if that node is to be executed multiple times
 * in that process instance).
 *
 * A node instance is uniquely identified (within its node instance
 * container!) by an id.
 *
 * Node instances can be nested, meaning that a node instance can
 * be created as part of another node instance.
 */
public interface NodeInstance {
    String getId();

    long getNodeId();

    Node getNode();

    String getNodeName();

    WorkflowProcessInstance getProcessInstance();

    /**
     * The node instance container that this node instance is part of.
     * If the node was defined in the top-level process scope, this is
     * the same as the process instance. If not, it is the node instance
     * container this node instance is executing in.
     *
     * @return the process instance that this node instance is executing in
     */
    NodeInstanceContainer getNodeInstanceContainer();

    Object getVariable(String variableName);

    void setVariable(String variableName, Object value);
}
