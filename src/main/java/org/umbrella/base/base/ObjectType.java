package org.umbrella.base.base;

import java.io.Externalizable;

/**
 * Semantic object type differentiator
 */
public interface ObjectType extends Externalizable{
    boolean isAssignableFrom(Class<?> clazz);

    boolean isAssignableTo(Class<?> clazz);

    boolean isAssignableFrom(ObjectType objectType);

    boolean isEvent();

    ValueType getValueType();

    Object getTypeKey();

    String getClassName();

    boolean hasField(String name);

    boolean isTemplate();
}
