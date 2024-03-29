package org.umbrella.kie.api.builder;

/** A Message generated by the building process of a KieModule */
public interface Message {
    /**
     * Returns the unique identifier of this message
     */
    long getId();

    /**
     * Returns the message level
     */
    Level getLevel();

    /***
     * Returns the path of the resource that caused the creation of this Message
     */
    String getPath();

    /**
     * Returns the line number in the resource of the issue that caused the creation
     * of this Message
     */
    int getLine();

    /**
     * Returns the column number in the resource of the issue that caused the
     * creation of this Message
     */
    int getColumn();

    /**
     * Return the text of this Message
     */
    String getText();

    public static enum Level {
        ERROR, WARNING, INFO;
    }
}
