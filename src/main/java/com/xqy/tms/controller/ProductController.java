package com.xqy.tms.controller;


import com.xqy.tms.Aannotion.JwtIgnore;
import com.xqy.tms.service.BaseService;
import com.xqy.tms.Factory.ServiceFactory;
import com.xqy.tms.dto.Result;
import com.xqy.tms.service.CommonService;
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

    @Resource
    private ServiceFactory serviceFactory;

    @GetMapping("/get/{type}/{id}")
    @JwtIgnore
    public Result<Optional> getOne(@PathVariable Long id, @PathVariable String type) throws IllegalAccessException {
        if (!ServiceFactory.dType.contains(type)){
            return Result.error("不存在的类型");
        }
        Optional byId = commonService.findById(id, type);
        return Result.success(byId);
    }

    @PostMapping("/saveOrUpdate/{type}")
    public Result<String> saveOrUpdate(@RequestBody Map<String, Object> map ,@PathVariable String type) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        if (!ServiceFactory.dType.contains(type)){
            return Result.error("不存在的类型");
        }
        commonService.saveOrUpdate(map,type);

        return Result.success("操作成功");
    }
    @GetMapping("/page/{type}/{pageNumber}/{pageSize}")
    public Result<Page> page(@PathVariable String type,@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        if (!ServiceFactory.dType.contains(type)){
            return Result.error("不存在的类型");
        }
        return Result.success(commonService.findPage(pageNumber,pageSize,type));
    }

    @GetMapping("/test/{type}")
    public Result<Optional> test(@PathVariable String type){
        BaseService cornerAluminum = serviceFactory.mType.get(type);
        return Result.success(cornerAluminum.findById(1L));
    }

}
