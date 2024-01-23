package org.umbrella.base.rule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.umbrella.base.base.ValueResolver;
import org.umbrella.base.base.ValueType;
import org.umbrella.base.reteoo.BaseTuple;
import org.umbrella.base.rule.accessor.AcceptsReadAccessor;
import org.umbrella.base.rule.accessor.ReadAccessor;
import org.umbrella.base.rule.accessor.TupleValueExtractor;

public class Declaration implements Externalizable, AcceptsReadAccessor, TupleValueExtractor{

    private String identifier;
    private String bindName;
    private ReadAccessor readAccessor;
    private Pattern pattern;
    private boolean internalFact;
    private transient Class<?> declarationClass;


    public Class<?> getDeclarationClass() {
        if (declarationClass == null) {
            declarationClass = readAccessor != null ? readAccessor.getExtractToClass() : null;
        }
        return declarationClass;
    }

    public void setDeclarationClass(Class<?> declarationClass) {
        this.declarationClass = declarationClass;
    }

    public Declaration() {
        this(null, null, null);
    }

    public Declaration(String identifier, Pattern pattern) {
        this(identifier, null, pattern, false);
    }

    public Declaration(String identifier, ReadAccessor extractor, Pattern pattern) {
        this.identifier = identifier;
        this.readAccessor = extractor;
        this.pattern = pattern;
    }

    public Declaration(String identifier, ReadAccessor extractor, Pattern pattern, boolean internalFact) {
        this.identifier = identifier;
        this.readAccessor = extractor;
        this.pattern = pattern;
        this.internalFact = internalFact;
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
    public ValueType getValueType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValueType'");
    }

    @Override
    public Object getValue(ValueResolver valueResolver, BaseTuple tuple) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }

    @Override
    public void setReadAccessor(ReadAccessor readAccessor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setReadAccessor'");
    }

    @Override
    public Declaration clone() {
        return null;
    }

}
