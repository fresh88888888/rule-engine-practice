package org.umbrella.kie.api.marshalling;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.umbrella.kie.api.runtime.Environment;
import org.umbrella.kie.api.runtime.KieSession;
import org.umbrella.kie.api.runtime.KieSessionConfiguration;

public interface Marshaller {
/**
     * Marshalls the given KieSession into the provided OutputStream
     * @param stream
     * @param ksession
     * @throws IOException
     */
    void marshall(OutputStream stream,
                  KieSession ksession) throws IOException;

    /**
     * Creates KieSession using default KieSessionConfiguration and
     * Environment. It will then unmarshall the stream into the session. Either KieSessionConfiguration or
     * Environment may be null and it will use the default.
     *
     * @param stream
     * @return unmarshlled KieSession
     * @throws IOException
     * @throws ClassNotFoundException
     */
    KieSession unmarshall(InputStream stream) throws IOException, ClassNotFoundException;

    /**
     * Creates KieSession using the given KieSessionConfiguration and
     * Environment. It will then unmarshall the stream into the session. Either KieSessionConfiguration or
     * Environment may be null and it will use the default.
     *
     * @param stream
     * @param config
     * @param environment
     * @return unmarshalled KieSession
     * @throws IOException
     * @throws ClassNotFoundException
     */
    KieSession unmarshall(InputStream stream,
                          KieSessionConfiguration config,
                          Environment environment) throws IOException, ClassNotFoundException;

    /**
     * Unmarshall the stream into the KieSession. All existing state in the session will be lost.
     *
     * @param stream
     * @param ksession
     * @throws IOException
     * @throws ClassNotFoundException
     */
    void unmarshall(InputStream stream,
                    KieSession ksession) throws IOException, ClassNotFoundException;

    /**
     * @return the {@link org.kie.api.marshalling.MarshallingConfiguration} object for this marshaller.
     */
    MarshallingConfiguration getMarshallingConfiguration();
}
