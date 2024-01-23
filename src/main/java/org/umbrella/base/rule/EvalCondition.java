package org.umbrella.base.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.umbrella.base.rule.accessor.EvalExpression;
import org.umbrella.base.rule.accessor.Wireable;

public class EvalCondition extends ConditionalElement implements Wireable{

    private EvalExpression expression;
    protected Declaration[] requiredDeclarations;
    private static final Declaration[] EMPTY_DECLARATIONS = new Declaration[0];
    private List<EvalCondition> cloned = Collections.emptyList();
    private Map<String, Declaration> outerDeclarations = Collections.EMPTY_MAP;

    public EvalCondition() {
        this(null);
    }

    public EvalCondition(Declaration[] requiredDeclarations) {
        this(null, requiredDeclarations);
    }
    
    public EvalCondition(EvalExpression expression, Declaration[] requiredDeclarations) {
        this.expression = expression;
        if (requiredDeclarations == null) {
            this.requiredDeclarations = EvalCondition.EMPTY_DECLARATIONS;
        } else {
            this.requiredDeclarations = requiredDeclarations;
        }
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
