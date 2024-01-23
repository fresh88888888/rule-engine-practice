package org.umbrella.base.rule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.umbrella.kie.internal.definition.KnowledgeDefinition;

/**
 * The type declaration class stores all type's metadata
 * declared in source files.
 */
public class TypeDeclaration implements KnowledgeDefinition, Externalizable, Comparable<TypeDeclaration>{

    public static final long NEVER_EXPIRES = -1;

    public static final int ROLE_BIT = 1;
    public static final int TYPESAFE_BIT = 2;
    public static final int FORMAT_BIT = 4;
    public static final int KIND_BIT = 8;
    public static final int NATURE_BIT = 16;

    public int setMask = 0;

    public enum Kind {
        CLASS, TRAIT, ENUM
    }

    public enum Format {
        POJO, TEMPLATE
    }

    public enum Nature {
        /**
         * A DECLARATION is a Type Declaration that does not contain any
         * field definition and that is just used to add meta-data to an
         * DEFINITION.
         * A DEFINITION of an exiting DEFINITION is also considered a DECLARATION
         */
        DECLARATION,
        /**
         * A DEFINITION is:
         * 1.- Type Declaration containing field definitions.
         * 2.- A DECLARATION with no previous DEFINITION
         */
        DEFINITION;

        public static final String ID = "nature";

        public static Nature parseNature(String nature) {
            if ("declaration".equalsIgnoreCase(nature)) {
                return DECLARATION;
            } else if ("definition".equalsIgnoreCase(nature)) {
                return DEFINITION;
            }
            return null;
        }
    }

    @Override
    public KnowledgeType gKnowledgeType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gKnowledgeType'");
    }

    @Override
    public String getNameSpace() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNameSpace'");
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public int compareTo(TypeDeclaration o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
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

}
