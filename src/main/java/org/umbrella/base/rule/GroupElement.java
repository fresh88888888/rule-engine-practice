package org.umbrella.base.rule;

import static org.umbrella.util.ClassUtils.findCommonSuperClass;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.umbrella.base.definitions.rule.impl.RuleImpl;

public class GroupElement extends ConditionalElement {

    public static final Type AND = Type.AND;
    public static final Type OR = Type.OR;
    public static final Type NOT = Type.NOT;
    public static final Type EXISTS = Type.EXISTS;

    private Type type;
    private boolean root;
    private Map<String, Declaration> outerDeclarations;
    private List<RuleConditionElement> children = new ArrayList<>();

    public GroupElement() {
        this(AND);
    }

    public GroupElement(Type type) {
        this.type = type;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(type);
        out.writeObject(children);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.type = (Type) in.readObject();
        this.children = (List) in.readObject();
    }

    public GroupElement addChild(final RuleConditionElement child) {
        if ((this.isNot() || this.isExists()) && this.children.size() > 0) {
            throw new RuntimeException(this.type.toString()
                    + "can have only a single child element. Either a single Pattern or another CE.");
        }
        this.children.add(child);

        return this;
    }
    /** Adds the given child as the (index)th child of the this GroupElement */
    public void addChild(final int index, final RuleConditionElement rce) {
        this.children.add(index, rce);
    }

    public GroupElement clone() {
        return clone();
    }

    protected GroupElement clone(boolean deepClone) {
        GroupElement cloned = new GroupElement();
        cloned.setType(this.getType());
        for (RuleConditionElement rce : children) {
            cloned.addChild(deepClone ? rce.clone() : rce);
        }
        
        return cloned;
    }

    /**
     * A public enum for CE types
     */
    public enum Type {
        AND(ScopeDelimiter.NEVER),
        OR(ScopeDelimiter.CONSENSUS),
        NOT(ScopeDelimiter.ALWAYS),
        EXISTS(ScopeDelimiter.ALWAYS);

        enum ScopeDelimiter {
            NEVER,
            CONSENSUS, // it isn't a scope delimiter only if a given Declaration is present on ALL
                       // branches
            ALWAYS
        }

        private final ScopeDelimiter scopeDelimiter;

        Type(final ScopeDelimiter scopeDelimiter) {
            this.scopeDelimiter = scopeDelimiter;
        }

        private Declaration resolveDeclaration(List<RuleConditionElement> children, String identifier) {
            for (int i = children.size() - 1; i >= 0; i--) {
                Declaration result = getOuterDeclarations(children.get(i), RuleImpl.DEFAULT_CONSEQUENCE_NAME)
                        .get(identifier);
                if (result != null) {
                    return result;
                }
            }
            
            return null;
        }

        /**
         * Returns a map of declarations that are
         * visible inside of an element of this type
         */
        private Map<String, Declaration> getInnerDeclarations(List<RuleConditionElement> children) {
            return getInnerDeclarations(children, RuleImpl.DEFAULT_CONSEQUENCE_NAME);
        }

        /**
         * Returns a map of declarations that are
         * visible inside of an element of this type
         * for the consequence with the given name
         */
        private Map<String, Declaration> getInnerDeclarations(List<RuleConditionElement> children,
                String consequenceName) {
            return getDeclarations(children, ScopeDelimiter.NEVER, consequenceName);
        }
        /**
         * Returns a map of declarations that are
         * visible outside of an element of this type
         */
        private Map<String, Declaration> getOuterDeclarations(List<RuleConditionElement> children,
                String consequenceName) {
            return getDeclarations(children, this.scopeDelimiter, consequenceName);
        }

        private Map<String, Declaration> getDeclarations(List<RuleConditionElement> children,
                ScopeDelimiter scopeDelimiter, String consequenceName) {
            if (scopeDelimiter == ScopeDelimiter.ALWAYS || children.isEmpty()) {
                return Collections.EMPTY_MAP;
            } else if (children.size() == 1) {
                return getOuterDeclarations(children.get(0), consequenceName);
            } else {
                Map<String, Declaration> declarations = new HashMap<>();
                if (scopeDelimiter == ScopeDelimiter.NEVER) {
                    for (RuleConditionElement rce : children) {
                        declarations.putAll(getOuterDeclarations(rce, consequenceName));
                        if (isConsequenceInvoker(rce, consequenceName)) {
                            break;
                        }
                    }
                } else if (scopeDelimiter == ScopeDelimiter.CONSENSUS) {
                    Iterator<RuleConditionElement> i = children.iterator();
                    RuleConditionElement rce = i.next();
                    Map<String, Declaration> elementDeclarations = getOuterDeclarations(rce, consequenceName);
                    if (isConsequenceInvoker(rce, consequenceName)) {
                        return elementDeclarations;
                    }
                    declarations.putAll(elementDeclarations);
                    while (i.hasNext()) {
                        rce = i.next();
                        elementDeclarations = getOuterDeclarations(rce, consequenceName);
                        if (isConsequenceInvoker(rce, consequenceName)) {
                            return elementDeclarations;
                        }
                        declarations.keySet().retainAll(elementDeclarations.keySet());
                        findCommonDeclarationClasses(declarations, elementDeclarations);
                    }
                }

                return declarations;
            }
        }
        
        private Map<String, Declaration> getOuterDeclarations(RuleConditionElement rce, String consequenceName) {
            return rce instanceof GroupElement ? ((GroupElement) rce).getOuterDeclarations(consequenceName)
                    : rce.getOuterDeclarations();
        }

        private boolean isConsequenceInvoker(RuleConditionElement rce, String consequenceName) {
            if (RuleImpl.DEFAULT_CONSEQUENCE_NAME.equals(consequenceName)) {
                return false;
            }

            if (rce instanceof NamedConsequenceInvoker
                    && ((NamedConsequenceInvoker) rce).invokesConsequence(consequenceName)) {

            }

            if (rce instanceof GroupElement) {
                for (RuleConditionElement child : ((GroupElement) rce).getChildren()) {
                    if (isConsequenceInvoker(child, consequenceName)) {
                        return true;
                    }
                }
            }

            return false;
        }
        
        private void findCommonDeclarationClasses(Map<String, Declaration> original, Map<String, Declaration> merged) {
            for (Map.Entry<String, Declaration> entry : original.entrySet()) {
                Declaration declaration = entry.getValue();
                declaration.setDeclarationClass(findCommonSuperClass(declaration.getDeclarationClass(),
                        merged.get(entry.getKey()).getDeclarationClass()));
            }
        }
    }

    public boolean isAnd() {
        return AND.equals(this.type);
    }

    public boolean isOr() {
        return OR.equals(this.type);
    }

    public boolean isNot() {
        return NOT.equals(this.type);
    }

    public boolean isExists() {
        return EXISTS.equals(this.type);
    }

    public String toString() {
        return this.type.toString() + this.children.toString();
    }
    public Type getType() {
        return type;
    }

    public boolean isRoot() {
        return root;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public void setOuterDeclarations(Map<String, Declaration> outerDeclarations) {
        this.outerDeclarations = outerDeclarations;
    }

    public List<RuleConditionElement> getChildren() {
        return children;
    }

    public void setChildren(List<RuleConditionElement> children) {
        this.children = children;
    }

    public Map<String, Declaration> getOuterDeclarations() {
        return outerDeclarations;
    }

    public Map<String, Declaration> getOuterDeclarations(String consequenceName) {
        if (outerDeclarations != null) {
            return outerDeclarations;
        } else if (root) {
            outerDeclarations = this.type.getOuterDeclarations(this.children, consequenceName);
            return outerDeclarations;
        }

        return this.type.getOuterDeclarations(this.children, consequenceName);
    }
    
    public Map<String, Declaration> getInnerDeclarations(String consequenceName) {
        return this.type.getInnerDeclarations(this.children, consequenceName);
    }

    @Override
    public Map<String, Declaration> getInnerDeclarations() {
        return this.type.getInnerDeclarations(this.children);
    }

    @Override
    public Declaration resolveDeclaration(String identifier) {
        return this.type.resolveDeclaration(this.children, identifier);
    }
}
