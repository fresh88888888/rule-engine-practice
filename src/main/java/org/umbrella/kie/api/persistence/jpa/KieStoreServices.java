package org.umbrella.kie.api.persistence.jpa;

import org.umbrella.kie.api.KieBase;
import org.umbrella.kie.api.internal.utils.KieService;
import org.umbrella.kie.api.runtime.Environment;
import org.umbrella.kie.api.runtime.KieSession;
import org.umbrella.kie.api.runtime.KieSessionConfiguration;

public interface KieStoreServices extends KieService{
    KieSession newKieSession(KieBase kBase, KieSessionConfiguration configuration, Environment environment);

    KieSession loadKieSession(Long id, KieBase kieBase, KieSessionConfiguration configuration, Environment environment);
}
