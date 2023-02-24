package com.xqy.tms.controller;

import com.xqy.tms.dto.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @GetMapping("/getById")
    public Result<String> getUser(){
        return Result.success("123");
    }
}
