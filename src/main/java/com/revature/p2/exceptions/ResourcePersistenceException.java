package com.revature.p2.exceptions;

public class ResourcePersistenceException extends P2Exception {

    public ResourcePersistenceException() {
        super(409, "Resource could not be persisted!");
    }

    public ResourcePersistenceException(String msg) {
        super(409, msg);
    }

    public ResourcePersistenceException(String msg, Throwable cause) {
        super(409, msg, cause);
    }

}
