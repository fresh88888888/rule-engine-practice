package org.umbrella.kie.api.builder;

public interface ReleaseId extends Comparable<ReleaseId>{
    String getGroupId();

    String getArtifactId();

    String getVersion();

    String toExternalForm();

    boolean isSnapshot();
}
