package com.revature.p2.exceptions;

public class P2Exception extends RuntimeException {

    private int status;

    public P2Exception(int status) {
        this.status = status;
    }

    public P2Exception(int status, Throwable cause) {
        super(cause);
        this.status = status;
    }

    public P2Exception(int status, String msg) {
        super(msg);
        this.status = status;
    }

    public P2Exception(int status, String msg, Throwable cause) {
        super(msg, cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}