package com.course.code.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


/**
 *  springboot 文件服务器
 *
 *  对应的httpClient上传文件的测试用例在F:\ideaWorkspace\AutoTest\Chapter6\src\main\java\com\course\code\httpclientdemo\HttpClientPost.java
 *  下的testUpfile
 *
 */
@RestController
public class FileUploadController {

    private static final Logger log = Logger.getLogger(FileUploadController.class);

    @PostMapping("/upload")
    public String upload(MultipartFile fileNameFromRequest) {
        if (fileNameFromRequest.isEmpty()) {

            return "fileNameFromRequest is empty";
        }

        String fileName = fileNameFromRequest.getOriginalFilename();
        System.out.println("文件名:" + fileName);
        String filePath = System.getProperty("user.dir");
        System.out.println(filePath);
        File dest = new File(filePath + File.separator + fileName);

        try {
            fileNameFromRequest.transferTo(dest);
            System.out.println("上传成功");
        }catch (Exception e) {
            System.out.println("上传异常");
            return "error";
        }
        return "success";

    }


}
