package org.umbrella.kie.api.definition;

/**
 * Marker interface for all KnowledgeDefinition's
 */
public interface KieDefinition {

    public KnowledgeType gKnowledgeType();

    public String getNameSpace();

    public String getId();
    
    public enum KnowledgeType {
        RULE, TYPE, WINDOW, ENUM, PROCESS, FUNCTION, QUERY
    }
}
