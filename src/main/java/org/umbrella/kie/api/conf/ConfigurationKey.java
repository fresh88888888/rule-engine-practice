package org.umbrella.kie.api.conf;

public class ConfigurationKey<T extends OptionsConfiguration> {
    private String type;

    public String type() {
        return type;
    }

    public ConfigurationKey(String type) {
        this.type = type;
    }
}
