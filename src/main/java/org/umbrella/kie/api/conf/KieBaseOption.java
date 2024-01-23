package org.umbrella.kie.api.conf;

/**
 * A markup interface for {@link KieBase} options.
 */
public interface KieBaseOption extends Option{
    String TYPE = "Base";

    default String type() {
        return TYPE;
    }
}
