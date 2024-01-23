package org.umbrella.base.rule;

/**
 * A markup interface for pattern source elements
 */
public interface PatternSource extends RuleConditionElement{

    boolean requiresLeftActivation();
}
