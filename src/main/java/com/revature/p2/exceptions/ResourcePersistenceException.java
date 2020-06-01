package com.revature.p2.exceptions;

public class ResourcePersistenceException extends P2Exception {

    public ResourcePersistenceException() {
        super("Resource could not be persisted!");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }

    public ResourcePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
