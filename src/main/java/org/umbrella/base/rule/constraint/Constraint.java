package org.umbrella.base.rule.constraint;

import java.io.Externalizable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.drools.compiler.rule.builder.RuleBuildContext;
import org.umbrella.base.base.ObjectType;
import org.umbrella.base.rule.Declaration;
import org.umbrella.base.rule.Pattern;
import org.umbrella.base.rule.RuleComponent;
import org.umbrella.util.bitmask.AllSetButLastBitMask;
import org.umbrella.util.bitmask.BitMask;

public interface Constraint extends RuleComponent, Externalizable, Cloneable {

    /**
     * Returns all the declarations required by the given constraint implementation.
     * 
     * @return
     */
    Declaration[] getRequireDeclarations();

    /**
     * When a rule contains multiple logical branches, i.e., makes use of 'OR' CE,
     * it is required to clone patterns and declarations for each logical branch.
     * Since this is done at ReteOO build type, when constraints were already
     * created, eventually some constraints need to update their references to the
     * declarations.
     * 
     * @param oldDecl
     * @param newDecl
     */
    void replaceDeclaration(Declaration oldDecl, Declaration newDecl);

    /**
     * Clones the Constraint
     * 
     * @return
     */
    Constraint clone();

    /** Returns the type of the constraint, either ALPHA, BETA or UNKNOWN */
    ConstraintType getType();

    /*
     * Returns true in case this constraint is a temporal constraint
     */
    boolean isTemporal();

    default BitMask getListenedPropertyMask(ObjectType objectType, List<String> settableProperties) {
        return getListenedPropertyMask(null, objectType, settableProperties);
    }

    /**
     * Returns property reactivity BitMask of this constraint.
     * 
     * @param pattern            which this constraint belongs to. if pattern is
     *                           empty, bind variables are considered to be declared
     *                           in the same pattern. It should be fine for alpha
     *                           constraints
     * @param objectType
     * @param settableProperties
     * @return property reactivity BitMask
     */
    default BitMask getListenedPropertyMask(Optional<Pattern> pattern, ObjectType objectType,
            List<String> settableProperties) {
        return AllSetButLastBitMask.get();
    }

    default boolean equal(Object obj) {
        return this.equal(obj);
    }

    default void registerEvaluationContext(RuleBuildContext context) {
    }

    default void mergeEvaluationContext(Constraint other) {
    }

    default Collection<String> getPackageNames() {
        return Collections.emptyList();
    }

    default void addPackageNames(Collection<String> otherPkgs){
    }

    /**
     * An enum for Constraint Types
     */
    public static enum ConstraintType {
        UNKNOWN("UNKNOWN"),
        ALPHA("ALPHA"),
        BETA("BETA"),
        XPATH("XPATH");

        private String desc;

        private ConstraintType(String desc) {
            this.desc = desc;
        }

        public String toString() {
            return "ConstraintType::" + desc;
        }
    }
}
