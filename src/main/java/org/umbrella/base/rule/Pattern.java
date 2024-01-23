package org.umbrella.base.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;

import org.umbrella.base.base.AcceptsClassObjectType;
import org.umbrella.base.base.ClassObjectType;

public class Pattern implements RuleConditionElement, AcceptsClassObjectType{

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
    public void setClassObjectType(ClassObjectType classObjectType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setClassObjectType'");
    }

    @Override
    public Map<String, Declaration> getInnerDeclarations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInnerDeclarations'");
    }

    @Override
    public Map<String, Declaration> getOuterDeclarations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOuterDeclarations'");
    }

    @Override
    public Declaration resolveDeclaration(String identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resolveDeclaration'");
    }

    @Override
    public Pattern clone() {
        return this;
    }

}
