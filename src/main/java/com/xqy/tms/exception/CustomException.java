package com.xqy.tms.exception;

import com.xqy.tms.base.BaseException;

public class CustomException extends BaseException {
    private static final long serialVersionUID = 1L;

    public CustomException(String message) {
        super(400, message);
    }
}