package org.umbrella.kie.api.runtime;

import org.umbrella.kie.api.time.Calendar;

public interface Calendars {
    Calendar get(String identifier);

    void set(String idenifier, Calendar value);
}
