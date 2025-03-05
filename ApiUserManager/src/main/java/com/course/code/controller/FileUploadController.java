package com.course.code.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty";
        }

        String fileName = file.getOriginalFilename();
        System.out.println("文件名:" + fileName);
        String filePath = System.getProperty("user.dir");
        System.out.println(filePath);
        File dest = new File(filePath + File.separator + fileName);

        try {
            file.transferTo(dest);
            System.out.println("上传成功");
        }catch (Exception e) {
            System.out.println("上传异常");
            return "error";
        }
        return "success";

    }


}
