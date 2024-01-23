package org.umbrella.kie.api.definition.process;

public enum NodeType {
    SCRIPT_TASK,
    HUMAN_TASK,
    WORKITEM_TASK,
    MILESTONE,
    THROW_EVENT,
    CATCH_EVENT,
    BOUNDARY_EVENT,
    AD_HOC_SUBPROCESS,
    EVENT_SUBPROCESS,
    SUBPROCESS,
    COMPLEX_GATEWAY,
    PARALLEL_GATEWAY,
    INCLUSIVE_GATEWAY,
    EXCLUSIVE_GATEWAY,
    EVENT_BASED_GATEWAY,
    START,
    END,
    CONDITIONAL,
    FOR_EACH,
    CATCH_LINK,
    THROW_LINK,
    FAULT,
    TIMER,
    BUSINESS_RULE,
    INTERNAL
}