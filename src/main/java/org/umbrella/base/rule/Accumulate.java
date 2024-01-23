package org.umbrella.base.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * A class to represent the Accumulate CE
 */
public class Accumulate extends ConditionalElement implements PatternSource{
    protected RuleConditionElement source;
    protected Declaration requiredDeclaration;
    protected Declaration[] innerDeclarationCache;
    
    protected List<Accumulate> cloned = Collections.emptyList();

    public Accumulate() {
    }

    public Accumulate(RuleConditionElement source, Declaration requiredDeclaration) {
        this.source = source;
        this.requiredDeclaration = requiredDeclaration;
        initInnerDeclarationCache();
    }

    private void initInnerDeclarationCache(){
        Map<String, Declaration> innerDeclarations = this.source.getInnerDeclarations();
        this.innerDeclarationCache = innerDeclarations.values().toArray(new Declaration[innerDeclarations.size()]);
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
    public boolean requiresLeftActivation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requiresLeftActivation'");
    }

    @Override
    public ConditionalElement clone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clone'");
    }

}
