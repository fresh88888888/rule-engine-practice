package org.umbrella.kie.api.internal.utils;

import java.util.ServiceLoader;

public interface KieService extends Comparable<KieService> {
    public static final String UNDEFINED = "undefined";

    default int servicePriority() {
        return 0;
    }

    // Override when you want to load a service based on a tag
    default String serviceTag() {
        return UNDEFINED;
    }

    @Override
    default int compareTo(KieService other) {
        if (servicePriority() == other.servicePriority()) {
            throw new IllegalArgumentException("\"Found 2 services with same priority (" + servicePriority() + "): "
                    + this.getClass().getCanonicalName() + " and " + other.getClass().getCanonicalName());
        }

        return servicePriority() - other.servicePriority();
    }

    static <T extends KieService> T load(Class<T> classService) {
        ServiceLoader<T> loader = ServiceLoader.load(classService, classService.getClassLoader());
        T service = null;
        for (T impl : loader) {
            if (service == null || impl.compareTo(service) > 0) {
                service = impl;
            }
        }
        return service;
    }

    static <T extends KieService> T loadWithTag(Class<T> classService, String tag) {
        if (tag == null || tag.equals(UNDEFINED)) {
            load(classService);
        }
        T service = null;
        ServiceLoader<T> loader = ServiceLoader.load(classService, classService.getClassLoader());
        for (T impl : loader) {
            if (tag.equals(impl.serviceTag())) {
                if (service == null) {
                    service = impl;
                } else {
                    throw new IllegalStateException("Found 2 services with the same tag \"" + tag + "\": "
                            + service.getClass().getCanonicalName() + " and " + impl.getClass().getCanonicalName());
                }
            }
        }

        return service;
    }
}
