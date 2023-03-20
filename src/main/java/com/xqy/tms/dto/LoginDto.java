package com.xqy.tms.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xqy
 * @description: 登录 dto
 * @date 2023/3/19 1:19
 */
@Data
public class LoginDto implements Serializable {

    private String username;

    private String password;

    private String role;

}
