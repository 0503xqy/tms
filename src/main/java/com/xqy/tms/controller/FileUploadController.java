package com.xqy.tms.controller;

import com.xqy.tms.dto.Result;
import com.xqy.tms.service.file.FileUtilService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author xqy
 * @description: FileUpload
 * @date 2023/3/10 19:54
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {


    @Resource
    private FileUtilService fileUtilService;

    @PostMapping("/upload")
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return  Result.success(fileUtilService.upload(file),"上传成功！");
    }
}
