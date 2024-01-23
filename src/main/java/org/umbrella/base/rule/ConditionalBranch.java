package org.umbrella.base.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;

public class ConditionalBranch extends ConditionalElement implements NamedConsequenceInvoker{

    private EvalCondition condition;
    private NamedConsequence consequence;
    private ConditionalBranch elseBranch;

    public ConditionalBranch() {
    }

    public ConditionalBranch(EvalCondition condition, NamedConsequence consequence, ConditionalBranch elseBranch) {
        this.condition = condition;
        this.consequence = consequence;
        this.elseBranch = elseBranch;
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
    public boolean invokesConsequence(String consequenceName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'invokesConsequence'");
    }

    @Override
    public ConditionalElement clone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clone'");
    }

}
