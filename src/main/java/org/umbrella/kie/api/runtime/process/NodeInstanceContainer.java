package org.umbrella.kie.api.runtime.process;

import java.util.Collection;

/**
 * A node instance container is a container that can contain
 * (zero or more) node instances.
 */
public interface NodeInstanceContainer {
    Collection<NodeInstance> getNodeInstances();

    NodeInstance getNodeInstance(long nodeInstanceId);
}
