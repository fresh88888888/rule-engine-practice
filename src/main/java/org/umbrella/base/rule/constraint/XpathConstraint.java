package org.umbrella.base.rule.constraint;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;

import org.umbrella.base.base.AcceptsClassObjectType;
import org.umbrella.base.base.ClassObjectType;
import org.umbrella.base.base.ValueResolver;
import org.umbrella.base.reteoo.BaseTuple;
import org.umbrella.base.rule.ContextEntry;
import org.umbrella.base.rule.Declaration;
import org.umbrella.base.rule.MutableTypeConstraint;
import org.umbrella.base.rule.accessor.DataProvider;
import org.umbrella.kie.api.runtime.rule.FactHandle;
import org.umbrella.util.ClassUtils;

public class XpathConstraint extends MutableTypeConstraint {
    private LinkedList<XpathChunk> chunks;
    private Declaration declaration;
    private Declaration xpathStartDeclaration;

    public XpathConstraint() {
        this(new LinkedList<>());
    }

    public XpathConstraint(LinkedList<XpathChunk> chunks) {
        this.chunks = chunks;
    }

    public XpathChunk addChunck(Class<?> clazz, String field, int index, boolean iterate, boolean lazy) {
        XpathChunk chunk = XpathChunk.get(clazz, field, index, iterate, lazy);
        if (chunk != null) {
            chunks.add(chunk);
        }

        return chunk;
    }

    @Override
    public boolean isAllowed(FactHandle handle, ValueResolver valueResolver) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAllowed'");
    }

    @Override
    public Declaration[] getRequireDeclarations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRequireDeclarations'");
    }

    @Override
    public void replaceDeclaration(Declaration oldDecl, Declaration newDecl) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replaceDeclaration'");
    }

    @Override
    public boolean isTemporal() {
        return false;
    }

    @Override
    public boolean isAllowedCachedLeft(ContextEntry entry, FactHandle handle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAllowedCachedLeft'");
    }

    @Override
    public boolean isAllowedCachedRight(ContextEntry entry, FactHandle handle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAllowedCachedRight'");
    }

    @Override
    public ContextEntry createContextEntry() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createContextEntry'");
    }

    @Override
    public MutableTypeConstraint clone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clone'");
    }

    @Override
    public String toString() {
        return this.chunks.toString();
    }

    private interface XpathEvaluator {
        Iterator<?> evaluate(ValueResolver valueResolver, BaseTuple leftBaseTuple, Object obj);
    }

    private static class SingleChunkXpathEvaluator implements XpathEvaluator {

        @Override
        public Iterator<?> evaluate(ValueResolver valueResolver, BaseTuple leftBaseTuple, Object obj) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'evaluate'");
        }
    }

    private static class XpathChunk implements AcceptsClassObjectType, Externalizable {

        private String field;
        private int index;
        private boolean iterate;
        private boolean lazy;
        private boolean array;

        public XpathChunk() {
            // for serialization only purposes.
        }

        public XpathChunk(String field, int index, boolean iterate, boolean lazy, boolean array) {
            this.field = field;
            this.index = index;
            this.iterate = iterate;
            this.lazy = lazy;
            this.array = array;
        }

        private static XpathChunk get(Class<?> clazz, String field, int index, boolean iterate, boolean lazy) {
            Method accessor = ClassUtils.getAccessor(clazz, field);
            if (accessor == null) {
                return null;
            }

            return new XpathChunk(field, index, iterate, lazy, iterate && accessor.getReturnType().isArray());
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
        public void setClassObjectType(ClassObjectType classObjectType) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setClassObjectType'");
        }
    }

    private static class XpathDataProvider implements DataProvider {

        @Override
        public Declaration[] getRequiredDeclarations() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRequiredDeclarations'");
        }

        @Override
        public Object creaObject() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'creaObject'");
        }

        @Override
        public Iterator getResults(BaseTuple tuple, ValueResolver valueResolver, Object providerContext) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getResults'");
        }

        @Override
        public void replaceDeclaration(Declaration declaration, Declaration resolved) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'replaceDeclaration'");
        }

        @Override
        public boolean isReactive() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isReactive'");
        }

        @Override
        public XpathDataProvider clone() {
            return this;
        }
    }

}
