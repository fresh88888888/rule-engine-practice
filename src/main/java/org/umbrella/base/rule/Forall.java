package org.umbrella.base.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The forall conditional element.
 */
public class Forall extends ConditionalElement {

    private Pattern basePattern;
    private List<Pattern> remainingPatterns;
    private boolean emptyBetaConstraints;
    
    public Forall() {
        this(null, new ArrayList<>());
    }

    public Forall(Pattern basePattern) {
        this(basePattern, new ArrayList<>());
    }

    public Forall(Pattern basePattern, List<Pattern> remainingPatterns) {
        this.basePattern = basePattern;
        this.remainingPatterns = remainingPatterns;
        this.emptyBetaConstraints = false;
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
    public ConditionalElement clone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clone'");
    }

}
