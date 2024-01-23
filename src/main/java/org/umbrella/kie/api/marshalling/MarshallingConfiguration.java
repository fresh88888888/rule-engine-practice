package org.umbrella.kie.api.marshalling;

public interface MarshallingConfiguration {
    ObjectMarshallingStrategyStore getObjectMarshallingStrategyStore();

    boolean isMarshallProcessInstances();

    boolean isMarshallWorkItems();
}
