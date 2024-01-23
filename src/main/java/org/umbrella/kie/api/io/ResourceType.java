package org.umbrella.kie.api.io;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResourceType implements Serializable {

    private final String name;
    private final String description;
    private final String defaultExtension;
    private final String[] otherExtension;
    private final String defaultPath;
    private final boolean fullyCoveredByExecModel;
    private static final Map<String, ResourceType> CACHE = Collections.synchronizedMap(new HashMap<>());

    public ResourceType(String name, String description, String defaultExtension, String[] otherExtension,
            String defaultPath, boolean fullyCoveredByExecModel) {
        this.name = name;
        this.description = description;
        this.defaultExtension = defaultExtension;
        this.otherExtension = otherExtension;
        this.defaultPath = defaultPath;
        this.fullyCoveredByExecModel = fullyCoveredByExecModel;
    }

    public static ResourceType addResourceTypeToRegistry(String resourceType, String description, String defaultPath,
            String defaultExtension, String... otherExtension) {
        return addResourceTypeToRegistry(
                resourceType, description, defaultExtension, defaultPath, false, otherExtension);
    }

    public static ResourceType addResourceTypeToRegistry(String resourceType, String description, String defaultPath,
            String defaultExtension, boolean isNative, String... otherExtension) {
        ResourceType resource = new ResourceType(
                resourceType, description, defaultExtension, otherExtension, defaultPath,
                isNative);
        CACHE.put(resourceType, resource);
        for (String ext : resource.getAllExtensions()) {
            CACHE.put("." + ext, resource);
        }

        return resource;
    }

    public List<String> getAllExtensions() {
        final List<String> extensions = new LinkedList<>();
        extensions.add(defaultExtension);
        extensions.addAll(Arrays.asList(otherExtension));

        return Collections.unmodifiableList(extensions);
    }

    public boolean matchResourceType(String resourceName) {
        if (resourceName != null) {
            if (resourceName.endsWith("." + defaultExtension)) {
                return true;
            }
            for (String extension : otherExtension) {
                if (resourceName.endsWith("." + extension)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ResourceType determinResourceType(String resourceName) {
        for (Map.Entry<String, ResourceType> entry : CACHE.entrySet()) {
            if (entry.getKey().endsWith(resourceName)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDefaultExtension() {
        return defaultExtension;
    }

    public String[] getOtherExtension() {
        return otherExtension;
    }

    public String getDefaultPath() {
        return defaultPath;
    }

    public boolean isFullyCoveredByExecModel() {
        return fullyCoveredByExecModel;
    }

    /** Rule Language */
    public static final ResourceType DRL = addResourceTypeToRegistry("DRL",
            "Drools Rule Language",
            "src/main/resources",
            "drl");

    public static final ResourceType DRLX = addResourceTypeToRegistry("DRLX",
            "Drools Extended Rule Language (experimental)",
            "src/main/resources",
            "drlx");

    /** DSL */
    public static final ResourceType DSL = addResourceTypeToRegistry("DSL",
            "Drools DSL",
            "src/main/resources",
            "dsl");

    /** DSL Rule */
    public static final ResourceType DSLR = addResourceTypeToRegistry("DSLR",
            "Drools DSL Rule",
            "src/main/resources",
            "dslr");
    /** Drools Rule Flow Language */
    public static final ResourceType DRF = addResourceTypeToRegistry("DRF",
            "Drools Rule Flow Language",
            "src/main/resources",
            "rf");

    /** jBPM BPMN2 Language */
    public static final ResourceType BPMN2 = addResourceTypeToRegistry("BPMN2",
            "jBPM BPMN2 Language",
            "src/main/resources",
            "bpmn", "bpmn2", "bpmn-cm");

    /** jBPM CMMN Language */
    public static final ResourceType CMMN = addResourceTypeToRegistry("CMMN",
            "jBPM CMMN Language",
            "src/main/resources",
            "cmmn");

    /** Decision Table */
    public static final ResourceType DTABLE = addResourceTypeToRegistry("DTABLE",
            "Decision Table",
            "src/main/resources",
            "drl.xls", "drl.xlsx", "drl.csv");

    /** XSD */
    public static final ResourceType XSD = addResourceTypeToRegistry("XSD",
            "XSD",
            "src/main/resources",
            "xsd");

    /** PMML */
    public static final ResourceType PMML = addResourceTypeToRegistry("PMML",
            "Predictive Model Markup Language",
            "src/main/resources",
            "pmml", false);

    /** DESCR */
    public static final ResourceType DESCR = addResourceTypeToRegistry("DESCR",
            "Knowledge Descriptor",
            "src/main/resources",
            "descr");

    /** JAVA */
    public static final ResourceType JAVA = addResourceTypeToRegistry("JAVA",
            "Java class",
            "src/main/java",
            "java");

    /** PROPERTIES */
    public static final ResourceType PROPERTIES = addResourceTypeToRegistry("PROPERTIES",
            "Properties file",
            "src/main/resources",
            "properties");

    /** Score Card - Workaround for double-dot file extensions for 6.0 */
    public static final ResourceType SCARD = addResourceTypeToRegistry("SCARD",
            "Score Crd",
            "src/main/resources",
            "sxls");

    /** Bayesian */
    public static final ResourceType BAYES = addResourceTypeToRegistry("Bayes",
            "Bayesian Belief Network",
            "src/main/resources",
            "xmlbif", "bif");

    public static final ResourceType TEMPLATE = addResourceTypeToRegistry("TEMPLATE",
            "Drools Rule Template",
            "src/main/resources",
            "drl.template");
    public static final ResourceType GDST = addResourceTypeToRegistry("GDST",
            "Guided Decision Table",
            "src/main/resources",
            "gdst");

    public static final ResourceType SCGD = addResourceTypeToRegistry("SCGD",
            "Guided Score Card",
            "src/main/resources",
            "scgd");

    public static final ResourceType SOLVER = addResourceTypeToRegistry("SOLVER",
            "OptaPlanner Solver Configuration",
            "src/main/resources",
            "solver");

    /** Decision Model and Notation (DMN) model */
    public static final ResourceType DMN = addResourceTypeToRegistry("DMN",
            "Decision Model and Notation",
            "src/main/resources",
            "dmn", false);

    /** DMN FEEL expression language */
    public static final ResourceType FEEL = addResourceTypeToRegistry("FEEL",
            "Friendly Enough Expression Language",
            "src/main/resources",
            "feel", false);

    /**
     * NO-Operation ResourceType - used for example to dynamically disable a given
     * AssemblerService
     */
    public static final ResourceType NOOP = addResourceTypeToRegistry("NOOP",
            "No-operation type",
            "src/main/resources",
            "no_op", false);
}
