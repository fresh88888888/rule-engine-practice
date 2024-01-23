package org.umbrella.kie.api.definition.process;


/**
 * A NodeContainer contains a set of Nodes
 * There are different types of NodeContainers and NodeContainers may be nested.
 */
public interface NodeContainer {
    Node[] getNodes();

    Node getNode(long id);

    Node getNodeByUniqueId(String nodeId);
}
