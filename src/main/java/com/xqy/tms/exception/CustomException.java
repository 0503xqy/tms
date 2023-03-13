package com.xqy.tms.exception;

import com.xqy.tms.base.BaseException;
import com.xqy.tms.enums.CustomExceptionEnum;

public class CustomException extends BaseException {
    private static final long serialVersionUID = 1L;
    public CustomException(String message) {
        super(400, message);
    }

    public CustomException(CustomExceptionEnum exceptionEnum){
        super(exceptionEnum.getCode(),exceptionEnum.getMessage());
    }
}