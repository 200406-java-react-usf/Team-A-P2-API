package com.revature.p2.exceptions;

public class ResourceNotFoundException extends P2Exception {

    public ResourceNotFoundException() {
        super("No resource found with provided search criteria!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
