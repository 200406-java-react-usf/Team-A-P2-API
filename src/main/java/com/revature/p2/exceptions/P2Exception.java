package com.revature.p2.exceptions;

public class P2Exception extends RuntimeException {

    public P2Exception(String message) {
        super(message);
    }

    public P2Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public P2Exception(Throwable cause) {
        super(cause);
    }

}