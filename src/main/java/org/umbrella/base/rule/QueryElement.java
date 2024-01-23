package org.umbrella.base.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;

public class QueryElement extends ConditionalElement {
    
    private Pattern resultPattern;
    private String queryName;
    private QueryArgument[] arguments;
    private int[] variableIndexes;
    private boolean openQuery;
    private boolean abductive;
    private Declaration[] requiredDeclarations;

    public QueryElement() {
    }

    public QueryElement(Pattern resultPattern, String queryName, QueryArgument[] arguments, int[] variableIndexes,
            boolean openQuery, boolean abductive, Declaration[] requiredDeclarations) {
        this.resultPattern = resultPattern;
        this.queryName = queryName;
        this.arguments = arguments;
        this.variableIndexes = variableIndexes;
        this.openQuery = openQuery;
        this.abductive = abductive;
        this.requiredDeclarations = requiredDeclarations;
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
