package com.xqy.tms.base;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int status;
    private String message;

    public BaseException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
