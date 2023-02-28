package com.xqy.tms.dto;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private boolean success;
    private T data;
    private String message;

    public Result(Integer code, boolean success, T data, String message) {
        this.code = code;
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200,true, data, "成功");
    }

    public static <T> Result<T> success(Integer code,T data, String message) {
        return new Result<>(code,true, data, message);
    }
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(200,true, data, message);
    }
    public static <T> Result<T> success(String message) {
        return new Result<>(200,true, null, message);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(500,false, null, message);
    }
    public static <T> Result<T> error(Integer code,String message) {
        return new Result<>(code,false, null, message);
    }
}

