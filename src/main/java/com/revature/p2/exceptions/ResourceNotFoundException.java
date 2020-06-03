package com.revature.p2.exceptions;

public class ResourceNotFoundException extends P2Exception {

    public ResourceNotFoundException() {
        super(404, "No resource found with provided search criteria!");
    }

    public ResourceNotFoundException(String msg) {
        super(404, msg);
    }

    public ResourceNotFoundException(String msg, Throwable cause) {
        super(404, msg, cause);
    }

}