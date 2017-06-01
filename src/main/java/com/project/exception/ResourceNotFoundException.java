package com.project.exception;

public class ResourceNotFoundException extends APIException {

    public ResourceNotFoundException(String message, String logMessage) {
        super(message, logMessage);
    }
}
