package com.cricket.app.enums;


/**
 * @author RahulRadhakrishnan
 */
public enum ServiceErrorType {
    
    /**
     * Service level errors
     */
    UNDEFINED_ERROR("000", "Undefined error, check everything"),
    ERROR("001", "Error"),
    MAPPER_ERROR("002", "Object mapper exception");
    
    
    /**
     * Error code
     */
    private final String code;
    /**
     * Error description
     */
    private final String description;
    
    
    /**
     * @param code
     * @param description
     */
    private ServiceErrorType(String code, String description) {
        this.code = code;
        this.description = description;
    }
    
    /**
     * @return String
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * @return String
     */
    public String getCode() {
        return this.code;
    }
    
    
    /**
     * toString method
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Error: [ ");
        builder.append("  " + "code" + ": ").append(this.code);
        builder.append(",  " + "description" + ": ").append(this.description);
        builder.append(" ]");
        return builder.toString();
    }
}
