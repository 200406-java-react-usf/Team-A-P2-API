package com.revature.p2.exceptions;

public class BadRequestException extends P2Exception {

    public BadRequestException() {
        super("An invalid request was made!");
    }

    public BadRequestException(String message) {
        super(message);
    }

}
