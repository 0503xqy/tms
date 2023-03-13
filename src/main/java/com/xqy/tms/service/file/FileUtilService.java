package com.xqy.tms.service.file;

import com.xqy.tms.enums.CustomExceptionEnum;
import com.xqy.tms.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author xqy
 * @description: TODO
 * @date 2023/3/10 19:56
 */
@Service
@Slf4j
public class FileUtilService {

    @Value("${file.upload-path}")
    private String imagePath;

    @Value("${file.upload-temp-path}")
    private String imageTempPath;

    @Value("${file.allow.suffix}")
    private String imageAllowSuffix;

    public String upload(MultipartFile file){
        // 验证文件类型是否是图片
        if (!file.getContentType().startsWith("image/")) {
            throw new CustomException(CustomExceptionEnum.FILE_DIS_SUFFIX);
        }
        // 获取文件名和后缀名
        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();

        // 判断是否为常用的图片后缀名
        if (!isAllow(fileExtension)){
           throw new CustomException(CustomExceptionEnum.FILE_DIS_SUFFIX);
        }
        // 生成随机文件名
        String fileName = UUID.randomUUID().toString() + fileExtension;

        // 保存文件到临时目录
        try {
            File uploadedFile = new File(imageTempPath+ "/" + fileName);
            file.transferTo(uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException(CustomExceptionEnum.FILE_SAVE_ERROR);
        }
        log.info("[文件上传]成功,文件名:{}",fileName);
        return fileName; // 返回上传成功页面或信息
    }

    public void moveFile(String fileName){
        // 源文件路径

        File sourceFile = new File(imageTempPath+"/"+fileName);
        // 目标文件路径
        File targetFile = new File(imagePath+"/"+fileName);
        try {
            // 将源文件移动到目标文件路径
            boolean success = sourceFile.renameTo(targetFile);
            if (success) {
                log.info("文件:{},移动成功!",fileName);
            } else {
                log.info("文件:{},移动失败!",fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Boolean isAllow(String ext){
        Set<String> suffix = Arrays.stream(imageAllowSuffix.split(",")).collect(Collectors.toSet());

        if (suffix.contains(ext.replace(".",""))){
            return true;
        }
        return false;
    }

}
