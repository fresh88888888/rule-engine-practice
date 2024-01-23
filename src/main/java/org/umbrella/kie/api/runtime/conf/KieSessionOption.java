package org.umbrella.kie.api.runtime.conf;

import org.umbrella.kie.api.conf.Option;

public interface KieSessionOption extends Option {
    String TYPE = "Base";

    default String type() {
        return TYPE;
    }
}
