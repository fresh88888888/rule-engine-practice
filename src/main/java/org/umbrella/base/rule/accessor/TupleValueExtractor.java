package org.umbrella.base.rule.accessor;

import org.umbrella.base.base.ValueResolver;
import org.umbrella.base.base.ValueType;
import org.umbrella.base.reteoo.BaseTuple;

public interface TupleValueExtractor extends Cloneable{

    ValueType getValueType();

    Object getValue(ValueResolver valueResolver, BaseTuple tuple);

    TupleValueExtractor clone();

    default Object getValue(BaseTuple tuple){
        return getValue(null, tuple);
    }
}
