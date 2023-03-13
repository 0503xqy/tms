package com.xqy.tms.enums;

/**
 * @author xqy
 * @description: my exception enum
 * @date 2023/3/12 20:45
 */
public enum CustomExceptionEnum {
    
    PRD_REPEAT(444,"产品重复！"),
    PRD_NOTFOUND(404,"产品未找到！"),
    TYPE_NOTFOUND(304,"错误的类型"),

    FILE_DIS_SUFFIX(501,"不允许的文件后缀！"),
    FILE_SAVE_ERROR(501,"保存失败！");

    private Integer code;
    private String message;
    CustomExceptionEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}

