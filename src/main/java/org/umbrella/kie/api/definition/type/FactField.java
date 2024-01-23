package org.umbrella.kie.api.definition.type;

import java.io.Externalizable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/**
 * A field from a declared fact type
 */
public interface FactField extends Externalizable{
    Class<?> getType();

    String getName();

    /**
     * @return true if this field is a key field. A key field
     *         is included in hashcode() calculation and on the equals()
     *         method evaluation. Non-key fields are not checked in this
     *         method.
     */
    boolean isKey();

    void set(Object bean, Object value);

    Object get(Object bean);

    int getIndex();

    List<Annotation> getFieldAnnotations();

    Map<String, Object> getMetaData();

}
