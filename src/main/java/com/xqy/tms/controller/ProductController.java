package com.xqy.tms.controller;


import com.xqy.tms.annotion.JwtIgnore;
import com.xqy.tms.dto.Result;
import com.xqy.tms.service.product.CommonService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/prd")
public class ProductController {

    @Resource
    private CommonService commonService;

    @GetMapping("/get/{type}/{id}")
    @JwtIgnore
    public Result<Optional> getOne(@PathVariable Long id, @PathVariable String type) throws IllegalAccessException {
        Optional byId = commonService.findById(id, type);
        return Result.success(byId);
    }

    @PostMapping("/saveOrUpdate/{type}")
    public Result<String> saveOrUpdate(@RequestBody Map<String, Object> map ,@PathVariable String type) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        commonService.saveOrUpdate(map,type);

        return Result.success("操作成功");
    }
    @GetMapping("/page/{type}/{pageNumber}/{pageSize}")
    public Result<Page> page(@PathVariable String type,@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return Result.success(commonService.findPage(pageNumber,pageSize,type));
    }

    @GetMapping("/test/{type}")
    public Result<Optional> test(@PathVariable String type){

        return Result.success(commonService.findById(1l,type));
    }

}
