package org.umbrella.kie.api.runtime;

import java.util.Collection;

import org.umbrella.kie.api.KieBase;
import org.umbrella.kie.api.KieBaseConfiguration;
import org.umbrella.kie.api.builder.ReleaseId;
import org.umbrella.kie.api.builder.Results;
import org.umbrella.kie.api.builder.model.KieBaseModel;
import org.umbrella.kie.api.builder.model.KieSessionModel;

/**
 * A container for all the KieBases of a given KieModule
 */
public interface KieContainer {
    /**
     * Disposes all the KieSessions created in this KieContainer.
     * If this KieContainer's containerId was registered with the KieServices, it
     * will free the ID and unregister it from KieServices.
     * If existing, dispose all JMX resources associated with this KieContainer.
     */
    void dispose();

    /**
     * Returns the ReleaseId of the KieModule wrapped by this KieContainer
     */
    ReleaseId getReleaseId();

    Results verify();

    /**
     * Builds the KieBases with the given name(s) in the KieModule wrapped by this
     * KieContainer
     * and return the Results of this building process
     */
    Results verify(String... kieBaseNames);

    /**
     * Updates this KieContainer to a KieModule with the given fixed ReleaseId (e.g.
     * com.acme:acme-rules:1.0.0.Final).
     * The new release id should not contain the placeholder versions like LATEST or
     * RELEASE as that will not work as expected.
     * The container will not automatically find and resolve the "latest" version
     * and will keep the old one in place.
     */
    Results updateToVersion(ReleaseId version);

    /**
     * Returns the names of all the KieBases available in this KieContainer
     */
    Collection<String> getKiebaseNames();

    /**
     * Returns the names of all the KieSessions defined in this KieContainer for the
     * given KieBase
     */
    Collection<String> getKieSessionNamesInKiebase(String kBaseName);

    /**
     * Returns the default KieBase in this KieContainer.
     * The returned KieBase will be managed by this KieContainer and then it will be
     * updated
     * when the KieContainer itself will be updated to a newer version of the
     * KieModule.
     * 
     * @throws RuntimeException if this KieContainer doesn't have any default
     *                          KieBase
     * @see org.kie.api.builder.model.KieBaseModel#setDefault(boolean)
     */
    KieBase getKieBase();

    /**
     * Returns the KieBase with the given name in this KieContainer.
     * The returned KieBase will be managed by this KieContainer and then it will be
     * updated
     * when the KieContainer itself will be updated to a newer version of the
     * KieModule.
     * 
     * @throws RuntimeException if this KieContainer doesn't have any KieBase with
     *                          the given name
     */
    KieBase getKieBase(String kieBaseName);

    /**
     * Creates a new default KieBase using the given configuration.
     * The returned KieBase will be detached from this KieContainer and then will
     * NOT be updated
     * when the KieContainer itself will be updated to a newer version of the
     * KieModule.
     * 
     * @throws RuntimeException if this KieContainer doesn't have any default
     *                          KieBase
     * @see org.kie.api.builder.model.KieBaseModel#setDefault(boolean)
     */
    KieBase newKieBase(KieBaseConfiguration configuration);

    /**
     * Creates a new KieBase with the given name using the given configuration.
     * The returned KieBase will be detached from this KieContainer and then will
     * NOT be updated
     * when the KieContainer itself will be updated to a newer version of the
     * KieModule.
     * 
     * @throws RuntimeException if this KieContainer doesn't have any KieBase with
     *                          the given name
     */
    KieBase newKieBase(String kiebaseName, KieBaseConfiguration configuration);

    /**
     * Creates a new {@link KieContainerSessionsPool} storing the sessions created
     * from this KieContainer.
     * Don't forget to {@link KieContainerSessionsPool#shutdown()} the pool when you
     * are done.
     *
     * @param initialSize the initial size of sessions in the pool
     * @return created {@link KieContainerSessionsPool}
     */
    KieContainerSessionsPool newKieContainerSessionsPool(int initialSize);

    /**
     * Creates the default KieSession for this KieContainer
     * 
     * @throws RuntimeException if this KieContainer doesn't have any default
     *                          KieSession
     * @see org.kie.api.builder.model.KieSessionModel#setDefault(boolean)
     */
    KieSession newKieSession();

    /**
     * Creates the default KieSession for this KieContainer with the given
     * configuration
     * 
     * @throws RuntimeException if this KieContainer doesn't have any default
     *                          KieSession
     * @see org.kie.api.builder.model.KieSessionModel#setDefault(boolean)
     */
    KieSession newKieSession(KieSessionConfiguration configuration);

    /**
     * Creates the default {@link KieSession} for this KieContainer using the given
     * Environment
     * 
     * @throws RuntimeException if this KieContainer doesn't have any default
     *                          KieSession
     * @see org.kie.api.builder.model.KieSessionModel#setDefault(boolean)
     */
    KieSession newKieSession(Environment environment);

    /**
     * Creates the default KieSession for this KieContainer with the given
     * configuration and Environment
     * 
     * @throws RuntimeException if this KieContainer doesn't have any default
     *                          KieSession
     * @see org.kie.api.builder.model.KieSessionModel#setDefault(boolean)
     */
    KieSession newKieSession(Environment environment, KieSessionConfiguration configuration);

    /**
     * Creates the KieSession with the given name for this KieContainer
     * 
     * @throws RuntimeException if this KieContainer doesn't have any KieSession
     *                          with the given name
     */
    KieSession newKieSession(String kieSessionName);

    /**
     * Creates the KieSession with the given name for this KieContainer using the
     * given Environment
     * 
     * @throws RuntimeException if this KieContainer doesn't have any KieSession
     *                          with the given name
     */
    KieSession newKieSession(String kieSessionName, Environment environment);

    /**
     * Creates the KieSession with the given name for this KieContainer with the
     * given configuration
     * 
     * @throws RuntimeException if this KieContainer doesn't have any KieSession
     *                          with the given name
     */
    KieSession newKieSession(String kieSessionName, KieSessionConfiguration configuration);

    /**
     * Creates the KieSession with the given name for this KieContainer using the
     * given Environment and configuration
     * 
     * @throws RuntimeException if this KieContainer doesn't have any KieSession
     *                          with the given name
     */
    KieSession newKieSession(String kieSessionName, Environment environment, KieSessionConfiguration configuration);

    /**
     * Creates the default StatelessKieSession for this KieContainer using the given
     * configuration
     * 
     * @throws RuntimeException if this KieContainer doesn't have any default
     *                          StatelessKieSession
     * @see org.kie.api.builder.model.KieSessionModel#setDefault(boolean)
     */
    StatelessKieSession newStatelessKieSession(KieSessionConfiguration configuration);

    /**
     * Creates the StatelessKieSession with the given name for this KieContainer
     * 
     * @throws RuntimeException if this KieContainer doesn't have any
     *                          StatelessKieSession with the given name
     */
    StatelessKieSession newStatelessKieSession(String kieSessionName);

    /**
     * Creates the StatelessKieSession with the given name for this KieContainer
     * using the given configuration
     * 
     * @throws RuntimeException if this KieContainer doesn't have any
     *                          StatelessKieSession with the given name
     */
    StatelessKieSession newStatelessKieSession(String kieSessionname, KieSessionConfiguration configuration);

    /**
     * Returns the ClassLoader used by this KieContainer
     */
    ClassLoader getClassLoader();

    /**
     * Returns the KieSessionConfiguration of the default KieSession for this
     * KieContainer
     */
    KieSessionConfiguration getKieSessionConfiguration();

    /**
     * Returns the KieSessionConfiguration of the KieSession with the given name for
     * this KieContainer
     */
    KieSessionConfiguration getKieSessionConfiguration(String kieSessionName);

    /**
     * Returns the KieBaseModel for the KieBase with the given name
     */
    KieBaseModel getKieBaseModel(String kBaseName);

    /**
     * Returns the KieSessionModel for the KieSession with the given name
     */
    KieSessionModel getKieSessionModel(String kSessionName);
}
