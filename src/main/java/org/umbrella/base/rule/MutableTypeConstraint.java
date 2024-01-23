package org.umbrella.base.rule;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.concurrent.atomic.AtomicBoolean;

import org.umbrella.base.rule.constraint.AlphaNodeFieldConstraint;
import org.umbrella.base.rule.constraint.BetaNodeFieldConstraint;
import org.umbrella.base.rule.constraint.Constraint;

public abstract class MutableTypeConstraint implements AlphaNodeFieldConstraint, BetaNodeFieldConstraint{

    private ConstraintType type = Constraint.ConstraintType.UNKNOWN;
    private transient AtomicBoolean inUse = new AtomicBoolean(false);

    public abstract MutableTypeConstraint clone();

    public MutableTypeConstraint cloneIfInUse() {
        if (inUse.compareAndSet(false, true)) {
            return this;
        }
        MutableTypeConstraint clone = clone();
        clone.inUse.set(true);
        return clone;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        type = (ConstraintType) in.readObject();
        
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(type);
    }

    @Override
    public ConstraintType getType() {
        return this.type;
    }
    public void setType(ConstraintType type) {
        this.type = type;
    }

    public AtomicBoolean getInUse() {
        return inUse;
    }

    public void setInUse(AtomicBoolean inUse) {
        inUse.getAndSet(true);
    }

}
