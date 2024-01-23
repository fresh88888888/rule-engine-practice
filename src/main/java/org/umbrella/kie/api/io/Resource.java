package org.umbrella.kie.api.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

/**
 * <p>
 * Generic interface to provide a Reader or InputStream for the underlying IO
 * resource.
 * </p>
 */
public interface Resource extends Serializable{

    /**
     * Open an InputStream to the resource, The user must close this when finshed.
     * 
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;

    Reader getReader() throws IOException;

    String getSourcePath();

    String getTargetPath();

    ResourceType getResourceType();

    ResourceConfiguration getConfiguration();

    Resource setSourcePath(String path);

    Resource setTargetPath(String path);

    Resource setConfigration(ResourceConfiguration conf);
}
