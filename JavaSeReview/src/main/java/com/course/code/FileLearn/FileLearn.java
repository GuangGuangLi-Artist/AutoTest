package com.course.code.FileLearn;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileLearn {

    @Test
    public void makeFile() throws IOException {
        File file1 = new File("D:\\javaproject\\AutoTest\\JavaSeReview\\src\\main\\java\\com\\course\\code\\FileLearn\\file1.txt");
        file1.createNewFile();
        System.out.println("name:" + file1.getName());
    }
}
