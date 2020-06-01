package com.revature.p2.exceptions;

public class AuthenticationException extends P2Exception {

    public AuthenticationException() {
        super("Authentication failed!");
    }

    public AuthenticationException(String message) {
        super(message);
    }

}
