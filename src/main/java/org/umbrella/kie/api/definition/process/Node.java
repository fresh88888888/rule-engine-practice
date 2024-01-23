package org.umbrella.kie.api.definition.process;

import java.util.List;
import java.util.Map;

/**
 * A Node represents an activity in the process flow chart.
 * Many different predefined nodes are supported out-of-the-box.
 */
public interface Node {
    long getId();

    String getNodeUniqueId();

    String getName();

    Map<String, List<Connection>> getIncomingConnections();

    Map<String, List<Connection>> getOutgoingConnections();

    List<Connection> getIncomingConnections(String type);
    
    List<Connection> getOutgoingConnections(String type);

    NodeContainer getNodeContainer();

    Map<String, Object> getMetaData();

    default NodeType getNodeType() {
        return NodeType.INTERNAL;
    }
}
