package org.umbrella.base.base;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Java class semantics <code>ObjectType</code>
 */
public class ClassObjectType implements ObjectType, ClassWireable{

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeExternal'");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readExternal'");
    }

    @Override
    public void wire(Class<?> klass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'wire'");
    }

    @Override
    public Class<?> getClassType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassType'");
    }

    @Override
    public boolean isAssignableFrom(Class<?> clazz) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAssignableFrom'");
    }

    @Override
    public boolean isAssignableTo(Class<?> clazz) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAssignableTo'");
    }

    @Override
    public boolean isAssignableFrom(ObjectType objectType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAssignableFrom'");
    }

    @Override
    public boolean isEvent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEvent'");
    }

    @Override
    public ValueType getValueType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValueType'");
    }

    @Override
    public Object getTypeKey() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTypeKey'");
    }

    @Override
    public String getClassName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassName'");
    }

    @Override
    public boolean hasField(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasField'");
    }

    @Override
    public boolean isTemplate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isTemplate'");
    }
}
