package org.umbrella.kie.api.conf;

import java.util.Collections;
import java.util.Set;

import org.umbrella.kie.api.PropertiesConfiguration;

public interface OptionsConfiguration<T extends Option, S extends SingleValueOption, M extends MultiValueOption>
        extends PropertiesConfiguration {
    void makeImmutable();

    <C extends T> void setOption(C option);

    <C extends S> C getOption(OptionKey<C> optionKey);

    default <C extends M> C getOption(OptionKey<C> optionKey, String subKey) {
        return null;
    }

    default <C extends M> Set<C> getOptionSubKeys(OptionKey<C> optionKey) {
        return Collections.emptySet();
    }

    ClassLoader getClassLoader();

    <X extends OptionsConfiguration<T, S, M>> X as(ConfigurationKey<X> configuration);
}
