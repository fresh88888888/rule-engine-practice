package org.umbrella.base.definitions.rule.impl;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class RuleImpl implements Externalizable {
    
    private static final int NO_LOOP_BIT = 1;
    private static final int AUTO_FOCUS_BIT = 1 << 1;
    private static final int LOCK_ON_ACTIVE_BIT = 1 << 2;
    private static final int LOGICAL_DEPENDENCY_BIT = 1 << 3;
    private static final int SEMANTICALLY_VALID_BIT = 1 << 4;
    private static final int EAGER_BIT = 1 << 5;
    private static final int DATA_DRIVEN_BIT = 1 << 6;
    private static final int ALL_MATCHES_BIT = 1 << 7;

    public static final String DEFAULT_CONSEQUENCE_NAME = "default";
    

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

}
