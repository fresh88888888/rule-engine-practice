package org.umbrella.base.rule;

import java.io.Externalizable;

import org.umbrella.base.base.ValueResolver;
import org.umbrella.base.reteoo.BaseTuple;
import org.umbrella.kie.api.runtime.rule.FactHandle;

public interface ContextEntry extends Externalizable{
    ContextEntry getNext();

    void setNext(ContextEntry entry);

    void updateFromTuple(ValueResolver valueResolver, BaseTuple tuple);

    void updateFromFactHandle(ValueResolver valueResolver, FactHandle handle);

    void resetFactHandle();

    void resetTuple();
}
