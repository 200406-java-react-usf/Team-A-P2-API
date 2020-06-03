package com.revature.p2.exceptions;

public class InternalServerErrorException extends P2Exception {

    public InternalServerErrorException() {
        super(500, "An unexpected error occurred. Please try again later.");
    }

    public InternalServerErrorException(String msg) {
        super(500, msg);
    }

    public InternalServerErrorException(String msg, Throwable cause) {
        super(500, msg, cause);
    }

}
