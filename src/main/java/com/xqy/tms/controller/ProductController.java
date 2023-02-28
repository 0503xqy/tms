package com.xqy.tms.controller;


import com.xqy.tms.Aannotion.JwtIgnore;
import com.xqy.tms.config.DTypeConfig;
import com.xqy.tms.dto.Result;
import com.xqy.tms.model.CornerAluminum;
import com.xqy.tms.service.CommonService;
import org.apache.commons.beanutils.BeanUtils;
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
        if (!DTypeConfig.dType.contains(type)){
            return Result.error("不存在的类型");
        }
        Optional byId = commonService.findById(id, type);
        return Result.success(byId);
    }

    @PostMapping("/saveOrUpdate/{type}")
    public Result<String> saveOrUpdate(@RequestBody Map<String, Object> map ,@PathVariable String type) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        if (!DTypeConfig.dType.contains(type)){
            return Result.error("不存在的类型");
        }
        commonService.saveOrUpdateCornerAluminum(map,type);

        return Result.success("操作成功");
    }
}
