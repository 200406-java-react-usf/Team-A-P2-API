package com.revature.p2.exceptions;

public class AuthorizationException extends P2Exception {

    public AuthorizationException() {
        super(403, "You do not have permission to perform that action.");
    }

    public AuthorizationException(String msg) {
        super(403, msg);
    }

    public AuthorizationException(String msg, Throwable cause) {
        super(403, msg, cause);
    }

}

