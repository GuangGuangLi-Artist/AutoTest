package com.course.code.commonFunction;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileReview {

    @Test
    public void testFile() {
        String property = System.getProperty("user.dir");
        File file = new File(property + "\\src\\main\\java\\FileDemo\\file2.txt");

        try {
            boolean fileIsTrue = file.createNewFile();
            System.out.println("创建文件是否成功: " + fileIsTrue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean exists = file.exists();
        System.out.println("exists: " + exists);

        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath: " + absolutePath);

        File fileNew = new File(property + "\\src\\main\\java\\FileDemo\\","newFile.txt");
        boolean rename = file.renameTo(fileNew);
        System.out.println("rename: " + rename);

        File fileFilter = new File(property + "\\src\\main\\java\\FileDemo");
        File[] listFiles = fileFilter.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                return new File(dir, name).isFile() && name.endsWith(".txt");
            }
        });

        for (File listFile : listFiles) {
            System.out.println("listFile: " + listFile.getName());
        }



    }
}
