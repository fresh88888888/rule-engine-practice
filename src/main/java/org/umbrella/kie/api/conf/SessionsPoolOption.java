package org.umbrella.kie.api.conf;

public class SessionsPoolOption implements SingleValueRuleBaseOption{
    public static final String PROPERTY_NAME = "drools.sessionPool";

    public static OptionKey KEY = new OptionKey(TYPE, PROPERTY_NAME);

    public static final SessionsPoolOption NO = SessionsPoolOption.get(-1);
    /**
     * Session pool size
     */
    private final int size;

    /**
     * Private constructor to enforce the use of the factory method
     * 
     * @param size
     */
    private SessionsPoolOption(int size) {
        this.size = size;
    }

    public static SessionsPoolOption get(int size) {
        return new SessionsPoolOption(size);
    }

    public String getPropertyName() {
        return PROPERTY_NAME;
    }
    
    /**
     * Returns the size of the session pool
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + size;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SessionsPoolOption other = (SessionsPoolOption) obj;
        return size == other.size;
    }

    @Override
    public String toString() {
        return size > 0 ? "SessionsPool of " + size : "NO SessionsPool";
    }
}
