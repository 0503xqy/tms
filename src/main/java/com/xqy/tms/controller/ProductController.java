package com.xqy.tms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xqy.tms.Aannotion.JwtIgnore;
import com.xqy.tms.dto.Result;
import com.xqy.tms.model.CornerAluminum;
import com.xqy.tms.service.CornerAluminumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/prd")
public class ProductController {

    @Resource
    private CornerAluminumService cornerAluminumService;

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/getById/{type}/{id}")
    @JwtIgnore
    public Result<Optional> getOne(@PathVariable Long id, @PathVariable String type){
        final Optional<CornerAluminum> cornerAluminumById = cornerAluminumService.findCornerAluminumById(id);
        return Result.success(cornerAluminumById);
    }

    @PostMapping("/saveOrUpdate/{type}")
    public Result<String> saveOrUpdate(@RequestBody Map<String,String> cornerAluminum, @PathVariable String type){
        if (type == "CornerAluminum"){
            CornerAluminum cornerAluminum1 = mapper.convertValue(cornerAluminum, CornerAluminum.class);
            CornerAluminum aluminum = cornerAluminumService.addCornerAluminum((CornerAluminum) cornerAluminum);
        }

        return Result.success("添加成功");
    }
}
