package org.umbrella.base.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;

/**
 * This class defines a Rete "Entry Point". An entry point is used as a source
 * of facts that are scoped to a separate alpha network. The alpha network is
 * not shared among separate entry points and this allows them to safelly run in
 * parallel and concurrent modes.
 * 
 */
public class EntryPointId extends ConditionalElement implements PatternSource{

    public static final EntryPointId DEFAULT = new EntryPointId("DEFAULT");

    private String entryPointId;
    
    public EntryPointId() {
    }

    public EntryPointId(String entryPointId) {
        this.entryPointId = entryPointId;
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
