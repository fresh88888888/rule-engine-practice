package org.umbrella.kie.api.io;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import org.umbrella.kie.api.definition.KieDescr;
import org.umbrella.kie.api.internal.utils.KieService;

/**
 * KieResource is a factory that provides resource implementations for the desired IO resource
 */
public interface KieResources extends KieService{
    Resource newFileSystemResource(File file);

    Resource newFileSystemResource(File file, String encoding);

    Resource newFileSystemResource(String fileName);

    Resource newFileSystemResource(String fileName, String encoding);

    Resource newFileSystemResource(byte[] bytes);

    Resource newFileSystenResource(byte[] bytes, String encoding);

    Resource newFileSystemResource(InputStream stream);

    Resource newFileSystemResource(InputStream stream, String encoding);

    Resource newFileSystemResource(Reader reader);

    Resource newFileSystemResource(Reader reader, String encoding);

    Resource newClassPathResource(String path);

    Resource newClassPathResource(String path, ClassLoader classLoader);

    Resource newClassPathResource(String path, Class<?> clazz);

    Resource newClassPathResource(String path, String encoding);

    Resource newClassPathResource(String path, String encoding, ClassLoader classLoader);

    Resource newClassPathResource(String path, String encoding, Class<?> clazz);

    Resource newDescrResource(KieDescr descr);

}
