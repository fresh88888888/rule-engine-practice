package org.umbrella.core.common;

import org.umbrella.base.common.NetworkNode;
import org.umbrella.core.reteoo.EntryPointNode;
import org.umbrella.core.reteoo.LeftTupleNode;
import org.umbrella.core.reteoo.ObjectSource;
import org.umbrella.core.reteoo.Sink;


/**
 * The base class for all Rete nodes.
 */
public abstract class BaseNode implements NetworkNode{

    protected int id;
    protected int memoryId = -1;

    private boolean streamMode;
    private int hashcode;

    public boolean isStreamMode() {
        return streamMode;
    }

    public void setStreamMode(boolean streamMode) {
        this.streamMode = streamMode;
    }

    @Override
    public int hashCode() {
        return hashcode;
    }

    public NetworkNode[] getSinks() {
        Sink[] sinks = null;
        // if (this instanceof EntryPointNode) {
        //     EntryPointNode source = (EntryPointNode)this;
        // }else if (this instanceof ObjectSource) {
            
        // }else if (this instanceof LeftTuples) {
            
        // }
        return null;
        
    }

}
