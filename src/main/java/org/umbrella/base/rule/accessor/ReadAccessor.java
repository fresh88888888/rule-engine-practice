package org.umbrella.base.rule.accessor;

import java.lang.reflect.Method;

import org.umbrella.base.base.ValueResolver;
import org.umbrella.base.base.ValueType;


/**
 * A public interface for Read accessors
 */
public interface ReadAccessor {

      Object getValue(Object object);

    ValueType getValueType();

    Class< ? > getExtractToClass();

    String getExtractToClassName();

    Method getNativeReadMethod();

    String getNativeReadMethodName();

    int getHashCode(Object object);

    int getIndex();

    Object getValue(ValueResolver valueResolver, Object object);

    char getCharValue(ValueResolver valueResolver, Object object);

    int getIntValue(ValueResolver valueResolver, Object object);

    byte getByteValue(ValueResolver valueResolver, Object object);

    short getShortValue(ValueResolver valueResolver, Object object);

    long getLongValue(ValueResolver valueResolver, Object object);

    float getFloatValue(ValueResolver valueResolver, Object object);

    double getDoubleValue(ValueResolver valueResolver, Object object);

    boolean getBooleanValue(ValueResolver valueResolver, Object object);

    boolean isNullValue(ValueResolver valueResolver, Object object);

    int getHashCode(ValueResolver valueResolver, Object object);

    boolean isGlobal();

    boolean isSelfReference();

}
