package org.umbrella.base.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;

import org.umbrella.base.rule.accessor.DataProvider;
import org.umbrella.base.rule.accessor.Wireable;

public class From extends ConditionalElement implements Wireable, PatternSource{

    private Pattern resultPattern;
    private Class<?> resultClass;
    private DataProvider dataProvider;

    public From() {
    }

    public From(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
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
    public boolean requiresLeftActivation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiresLeftActivation'");
    }

    @Override
    public void wire(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'wire'");
    }

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
    public ConditionalElement clone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clone'");
    }

}
