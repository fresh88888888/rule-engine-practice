package org.umbrella.kie.api;

import java.io.File;
import java.util.Properties;

import org.kie.api.marshalling.KieMarshallers;
import org.umbrella.kie.api.builder.KieBuilder;
import org.umbrella.kie.api.builder.KieFileSystem;
import org.umbrella.kie.api.builder.KieRepository;
import org.umbrella.kie.api.builder.KieScanner;
import org.umbrella.kie.api.builder.ReleaseId;
import org.umbrella.kie.api.builder.model.KieModuleModel;
import org.umbrella.kie.api.command.KieCommands;
import org.umbrella.kie.api.internal.utils.KieService;
import org.umbrella.kie.api.io.KieResources;
import org.umbrella.kie.api.logger.KieLoggers;
import org.umbrella.kie.api.persistence.jpa.KieStoreServices;
import org.umbrella.kie.api.runtime.Environment;
import org.umbrella.kie.api.runtime.KieContainer;
import org.umbrella.kie.api.runtime.KieSessionConfiguration;

/**
 * <p>
 * The KieServices is a thread-safe singleton acting as a hub giving access to
 * the other
 * Services provided by Kie. As general rule a getX() method just returns a
 * reference to another
 * singleton while a newX() one creates a new instance.
 * </p>
 * <p>
 * It is possible to obtain a KieServices reference via its Factory as it
 * follows
 * </p>
 * 
 * <pre>
 * KieServices kieServices = KieServices.Factory.get();
 * </pre>
 */
public interface KieServices extends KieService {
    
    /**
     * Returns the KieResources, a factory that provides Resource implementations
     * for the desired IO resource
     * 
     * @return resources
     */
    KieResources getResources();
    
    /**
     * Returns the KieRepository, a singleton acting as a repository for all the
     * available KieModules
     * 
     * @return repository
     */
    KieRepository getRepository();

    /**
     * Returns the KieCommands, a factory for Commands
     * 
     * @return commands
     */
    KieCommands getCommands();

    /**
     * Returns the KieMarshallers service
     * 
     * @return marshallers
     */
    KieMarshallers getMarshallers();
    /**
     * Returns KieLoggers, a factory for KieRuntimeLogger
     * 
     * @return loggers
     */
    KieLoggers getLoggers();

    /**
     * Returns KieStoreServices
     * 
     * @return store services
     */
    KieStoreServices getKieStoreServices();

    /**
     * Returns KieContainer for the classpath, this a global singleton.
     * 
     * @return kie classpath container
     */
    KieContainer getKieClassPathKieContainer();

    /**
     * Returns KieContainer for the classpath using the given classLoader,
     * this a global singleton.
     * 
     * @param classLoader classLoader
     * @return kie classpath container
     *
     * @throws IllegalStateException if this method get called twice with 2
     *                               different ClassLoaders
     */
    KieContainer getKieClassPathContainer(ClassLoader loader);

    /**
     * Returns KieContainer for the classpath enforcing the given containerId,
     * this a global singleton.
     * <p>
     * If enforcing the containerId is successful, the KieContainer and its
     * containerId are registered within the KieServices.
     * Deregistration can be performed by calling {@link KieContainer#dispose()} on
     * the resulting KieContainer.
     * </p>
     * <p>
     * If you do not want to enforce a specific containerId, use the
     * {@link #getKieClasspathContainer()} method instead.
     * </p>
     * 
     * @param containerId the containerId to enforce (non-null).
     * @return kie classpath container
     *
     * @throws IllegalStateException if the containerId is already existing for
     *                               another container and therefore cannot be
     *                               enforced.
     */
    KieContainer getKieClassPathContainer(String containerId);
    
    /**
     * Returns KieContainer for the classpath enforcing the given containerId and
     * using the given classLoader,
     * this a global singleton.
     * <p>
     * If enforcing the containerId is successful, the KieContainer and its
     * containerId are registered within the KieServices.
     * Deregistration can be performed by calling {@link KieContainer#dispose()} on
     * the resulting KieContainer.
     * </p>
     * 
     * @param containerId the containerId to enforce (non-null).
     * @param classLoader classLoader
     * @return kie classpath container
     *
     * @throws IllegalStateException if this method get called twice with 2
     *                               different ClassLoaders, or if the containerId
     *                               is already existing for another container and
     *                               therefore cannot be enforced.
     */
    KieContainer getKieClassPathContainer(String containerId, ClassLoader loader);

    /**
     * Creates a new KieContainer for the classpath, regardless if there's already
     * an existing one
     * 
     * @return new kie classpath container
     */
    KieContainer newKieClassPathContainer();

    /**
     * Creates a new KieContainer for the classpath using the given classLoader,
     * regardless if there's already an existing one
     * 
     * @param classLoader classLoader
     * @return new kie classpath container
     */
    KieContainer newKieClassPathContainer(ClassLoader loader);

    /**
     * Creates a new KieContainer for the classpath,
     * regardless if there's already an existing one,
     * enforcing the given containerId.
     * <p>
     * If enforcing the containerId is successful, the KieContainer and its
     * containerId are registered within the KieServices.
     * Deregistration can be performed by calling {@link KieContainer#dispose()} on
     * the resulting KieContainer.
     * </p>
     * <p>
     * If you do not want to enforce a specific containerId, use the
     * {@link #newKieClasspathContainer()} method instead.
     * </p>
     * 
     * @param containerId a unique containerId (non-null).
     * @return new kie classpath container
     * @throws IllegalStateException if the containerId is already existing for
     *                               another container, and therefore cannot be
     *                               enforced.
     */
    KieContainer newKieClassPathContainer(String containerId);

    /**
     * Creates a new KieContainer for the classpath using the given classLoader,
     * regardless if there's already an existing one,
     * enforcing the given containerId.
     * <p>
     * If enforcing the containerId is successful, the KieContainer and its
     * containerId are registered within the KieServices.
     * Deregistration can be performed by calling {@link KieContainer#dispose()} on
     * the resulting KieContainer.
     * </p>
     * 
     * @param containerId a unique containerId (non-null).
     * @param classLoader classLoader
     * @return new kie classpath container
     * @throws IllegalStateException if the containerId is already existing for
     *                               another container, and therefore cannot be
     *                               enforced.
     */
    KieContainer newKieClassPathContainer(String containerId, ClassLoader loader);
    
    /**
     * Creates a new KieContainer for the classpath using the given classLoader,
     * regardless if there's already an existing one,
     * enforcing the given containerId.
     * <p>
     * If enforcing the containerId is successful, the KieContainer and its
     * containerId are registered within the KieServices.
     * Deregistration can be performed by calling {@link KieContainer#dispose()} on
     * the resulting KieContainer.
     * </p>
     * 
     * @param containerId          a unique containerId (non-null).
     * @param classLoaderContainer classLoader
     * @param releaseId            release id of this container
     * @return new kie classpath container
     * @throws IllegalStateException         if the containerId is already existing
     *                                       for another container, and therefore
     *                                       cannot be enforced.
     * @throws UnsupportedOperationException if the operation is not supported by
     *                                       the kie services
     */
    default KieContainer newKieClasspathContainer(String containerId, ClassLoader classLoaderContainer,
            ReleaseId releaseId) {
        throw new UnsupportedOperationException("new container with release id is not supported");
    }

    /**
     * Creates a new KieContainer wrapping the KieModule with the given ReleaseId
     * 
     * @param releaseId releaseId
     * @return new kie container
     */
    KieContainer newKieContainer(ReleaseId releaseId);

    /**
     * Creates a new KieContainer wrapping the KieModule with the given ReleaseId
     * and enforcing the given containerId.
     * <p>
     * If enforcing the containerId is successful, the KieContainer and its
     * containerId are registered within the KieServices.
     * Deregistration can be performed by calling {@link KieContainer#dispose()} on
     * the resulting KieContainer.
     * </p>
     * <p>
     * If you do not want to enforce a specific containerId, use the
     * {@link #newKieContainer(ReleaseId)} method instead.
     * </p>
     * 
     * @param containerId a unique containerId (non-null).
     * @param releaseId   releaseId
     * @return new kie container
     * @throws IllegalStateException if the containerId is already existing for
     *                               another container, and therefore cannot be
     *                               enforced.
     */
    KieContainer newKieContainer(String containerId, ReleaseId releaseId);

    /**
     * Creates a new KieContainer wrapping the KieModule with the given ReleaseId
     * and using the given class loader
     * 
     * @param releaseId   releaseId
     * @param classLoader classLoader
     * @return new kie container
     */
    KieContainer newKieContainer(ReleaseId releaseId, ClassLoader loader);

    /**
     * Creates a new KieContainer wrapping the KieModule with the given ReleaseId,
     * using the given class loader
     * and enforcing the given containerId.
     * <p>
     * If enforcing the containerId is successful, the KieContainer and its
     * containerId are registered within the KieServices.
     * Deregistration can be performed by calling {@link KieContainer#dispose()} on
     * the resulting KieContainer.
     * </p>
     * 
     * @param containerId a unique containerId (non-null).
     * @param releaseId   releaseId
     * @param classLoader classLoader
     * @return new kie container
     * @throws IllegalStateException if the containerId is already existing for
     *                               another container, and therefore cannot be
     *                               enforced.
     */
    KieContainer newKieContainer(String containerId, ReleaseId releaseId, ClassLoader loader);

    /**
     * Creates a maven based KieScanner to automatically discover if there are new
     * releases of the KieModule
     * (and its dependencies) wrapped by the given KieContainer
     * 
     * @param kieContainer kieContainer
     * @return new kie scanner
     */
    KieScanner newKieScanner(KieContainer container);

    /**
     * Creates a file system based KieScanner to automatically discover if there are
     * new releases of the KieModule
     * (and its dependencies) wrapped by the given KieContainer
     * 
     * @param kieContainer     kieContainer
     * @param repositoryFolder The folder where the new releases will be dropped
     * @return new kie scanner
     */
    KieScanner newKieScanner(KieContainer container, String repositoryFolder);

    /**
     * Creates a new KieBuilder to build the KieModule contained in the given folder
     * 
     * @param rootFolder rootFolder
     * @return new kie builder
     */
    KieBuilder newKieBuilder(File rootFolder);

    /**
     * Creates a new KieBuilder to build the KieModule contained in the given
     * KieFileSystem
     * 
     * @return new kie builder
     */
    KieBuilder newKieBuilder(KieFileSystem kieFileSystem);

    /**
     * Creates a new KieBuilder to build the KieModule contained in the given
     * KieFileSystem
     * and using the given class loader
     * 
     * @return new kie builder
     */
    KieBuilder newKieBuilder(KieFileSystem kieFileSystem, ClassLoader loader);

    /**
     * Creates a new ReleaseId with the given groupId, artifactId and version
     * 
     * @param groupId    groupId
     * @param artifactId artifactId
     * @param version    version
     * @return new release id
     */
    ReleaseId newReleaseId(String groupId, String artifactId, String version);

    /**
     * Creates a new KieFileSystem used to programmatically define the resources
     * composing a KieModule
     * 
     * @return new kie file system
     */
    KieFileSystem newKieFileSystem();

    /**
     * Creates a new KieModuleModel to programmatically define a KieModule
     * 
     * @return new kie module model
     */
    KieModuleModel newKieModuleModel();
    /**
     * Create a KieBaseConfiguration on which properties can be set.
     * 
     * @return new kiebase configuration
     */
    KieBaseConfiguration newKieBaseConfiguration();

    /**
     * Create a KieBaseConfiguration on which properties can be set. Use
     * the given properties file.
     * 
     * @param properties properties
     * @return new kiebase configuration
     */
    KieBaseConfiguration newKieBaseConfiguration(Properties properties);

    /**
     * Create a KieBaseConfiguration on which properties can be set. Use
     * the given properties file and ClassLoader - either of which can be null.
     * 
     * @param properties  properties
     * @param classLoader classLoader
     * @return new kiebase configuration
     *
     * @deprecated The classLoader has to be defined when creating the KieContainer,
     *             so the one passed here will be just ignored
     */
    KieBaseConfiguration newKieBaseConfiguration(Properties properties, ClassLoader loader);

    /**
     * Create a KieSessionConfiguration on which properties can be set.
     * 
     * @return new kiesession configuration
     */
    KieSessionConfiguration newKieSessionConfiguration();

    /**
     * Create a KieSessionConfiguration on which properties can be set.
     * 
     * @param properties properties
     * @return new kiesession configuration
     */
    KieSessionConfiguration newKieSessionConfiguration(Properties properties);

    /**
     * Create a KieSessionConfiguration on which properties can be set. Use
     * the given properties file and ClassLoader - either of which can be null.
     * 
     * @param properties  properties
     * @param classLoader classLoader
     * @return new kiesession configuration
     */
    KieSessionConfiguration newKieSessionConfiguration(Properties properties, ClassLoader loader);

    /**
     * Instantiate and return an Environment
     *
     * @return
     *         The Environment
     */
    Environment newEnvironment();
    /**
     * Returns a reference to the KieServices singleton
     */
    static KieServices get() {
        return Factory.get();
    }
    
    /**
     * A Factory for this KieServices
     */
    public class Factory {
        private static class LazyHolder {
            private static KieServices INSTANCE = (KieServices) KieService.load(KieService.class);
        }

        /**
         * Returns a reference to the KieServices singleton
         */
        public static KieServices get(){
            return LazyHolder.INSTANCE;
        }
    }
    
}
