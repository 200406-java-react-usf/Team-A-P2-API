package com.revature.p2.exceptions;

public class BadRequestException extends P2Exception {

    public BadRequestException() {
        super(400, "Invalid request made!");
    }

    public BadRequestException(String msg) {
        super(400, msg);
    }

    public BadRequestException(String msg, Throwable cause) {
        super(400, msg, cause);
    }

}
