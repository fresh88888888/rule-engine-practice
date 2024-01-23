package org.umbrella.base.rule.accessor;

import java.io.Serializable;
import java.util.Iterator;

import org.umbrella.base.base.ValueResolver;
import org.umbrella.base.reteoo.BaseTuple;
import org.umbrella.base.rule.Declaration;

public interface DataProvider extends Serializable, Cloneable{
    Declaration[] getRequiredDeclarations();

    Object creaObject();

    Iterator getResults(BaseTuple tuple, ValueResolver valueResolver, Object providerContext);

    DataProvider clone();

    void replaceDeclaration(Declaration declaration, Declaration resolved);

    boolean isReactive();
}
