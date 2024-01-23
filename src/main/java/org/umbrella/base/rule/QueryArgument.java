package org.umbrella.base.rule;

import java.io.Externalizable;

import org.umbrella.base.base.ValueResolver;
import org.umbrella.base.reteoo.BaseTuple;

public interface QueryArgument extends Externalizable{
    QueryArgument normalize(ClassLoader classLoader);

    Object getValue(ValueResolver valueResolver, BaseTuple tuple);
}
