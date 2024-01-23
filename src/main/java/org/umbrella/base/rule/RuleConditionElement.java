package org.umbrella.base.rule;

import java.io.Externalizable;
import java.util.Map;

public interface RuleConditionElement extends RuleComponent, Externalizable, Cloneable {

    /**
     * Returns a Map of declarations that are
     * visible inside this conditional element
     * 
     * @return
     */
    Map<String, Declaration> getInnerDeclarations();

    /**
     * Returns a Map of declarations that are visible
     * outside this conditional element.
     * 
     * @return
     */
    Map<String, Declaration> getOuterDeclarations();

    /**
     * Resolves the given identifier in the current scope and
     * returns the Declaration object for the declaration.
     * Returns null if identifier can not be resolved.
     * 
     * @param identifier
     * @return
     */
    Declaration resolveDeclaration(String identifier);

    /**
     * Returns a clone from itself
     * 
     * @return
     */
    RuleConditionElement clone();

}
