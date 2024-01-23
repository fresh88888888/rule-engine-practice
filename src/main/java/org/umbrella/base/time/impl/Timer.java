package org.umbrella.base.time.impl;

import org.umbrella.base.reteoo.BaseTuple;
import org.umbrella.base.rule.RuleConditionElement;
import org.umbrella.base.time.JobHandle;
import org.umbrella.base.time.Trigger;
import org.umbrella.kie.api.runtime.Calendars;

public interface Timer extends RuleConditionElement{
    Trigger createTrigger(long timestamp, String[] calendarNames, Calendars calendars);

    Trigger createTrigger(long timestamp, BaseTuple leftTuple, JobHandle jh, String[] calendarNames,
            Calendars calendars);
}
