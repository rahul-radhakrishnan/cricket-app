package com.cricket.app.enums;

/**
 * Service Layer static messages.
 */
public enum Messages {
    
    // This enum can be used for having log messages
    
    ERROR("Error");


    /**
     * message
     */
    private final String message;

    /**
     * @param message
     */
    Messages(String message) {
        this.message = message;
    }

    /**
     * @return code
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return this.message;
    }

}

