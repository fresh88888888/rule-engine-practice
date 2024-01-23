package org.umbrella.base;

import org.umbrella.base.rule.TypeDeclaration;

public interface RuleBase {

    ClassLoader getRootClassLoader();

    TypeDeclaration getOrCreateExactTypeDeclaration(Class<?> nodeClass);

    TypeDeclaration getTypeDeclaration(Class<?> classType);
}
