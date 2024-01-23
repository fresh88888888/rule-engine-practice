package org.umbrella.base.rule.accessor;

import org.umbrella.base.base.ValueResolver;
import org.umbrella.base.reteoo.BaseTuple;
import org.umbrella.base.rule.Declaration;

public interface EvalExpression extends Invoker, Cloneable {
    Object createContext();

    EvalExpression clone();

    void replaceDeclaration(Declaration declaration, Declaration resolved);

    boolean evaluate(BaseTuple tuple, Declaration[] requireDeclarations, ValueResolver valueResolver, Object context);

    default EvalExpression clonePreservingDeclarations(EvalExpression original) {
        return original;
    }
}
