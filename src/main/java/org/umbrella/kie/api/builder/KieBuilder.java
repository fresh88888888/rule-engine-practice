package org.umbrella.kie.api.builder;

import org.umbrella.kie.api.io.Resource;

/**
 * KieBuilder is a builder for the resources contained in a KieModule
 */
public interface KieBuilder {

    /**
     * A marker interace implemented by the different type of projects supported by
     * this KieBuilder
     */
    public interface ProjectType {
    }

    /**
     * Sets the other KieModules from which the KieModule that has to be built by
     * this KieBuilder depends on
     * 
     * @param dependencies
     * @return
     */
    KieBuilder setDependencies(KieModule... dependencies);
    
    /**
     * Sets the other Resources from which the KieModule that has to be built by
     * this KieBuilder depends on
     * 
     * @param resources
     * @return
     */
    KieBuilder setDependencies(Resource... resources);
    
    /**
     * Builds all the KieBases contained in the KieModule for which this KieBuilder
     * has been created
     */
    KieBuilder buildAll();

    KieBuilder buildAll(Class<? extends ProjectType> projectClass);

    /**
     * Returns the Results of the building process.
     * Invokes <code>buildAll()</code> if the KieModule hasn't been built yet
     */
    Results getResults();
    
    /** Returns the KieModule for which this KieBuilder has been created */
    KieModule getKieModule();
    
    /**
     * Returns the KieModule for which this KieBuilder has been created of the
     * specific projectClass
     */
    KieModule getKieModule(Class<? extends ProjectType> projectClass);

}
