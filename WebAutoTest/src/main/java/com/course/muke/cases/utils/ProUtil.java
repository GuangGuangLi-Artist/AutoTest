package com.course.muke.cases.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件的对象喝方法
 */

public class ProUtil {

    public Properties properties;
    public ProUtil(String filePath){
        properties= readProperties(filePath );
    }

    private  Properties readProperties(String filePath){
        Properties ps = new Properties();
        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fileInputStream);
            ps.load(bis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return ps;
    }

    public String getPro(String key){
        String value;
        if(properties.containsKey(key)){
            value = properties.getProperty(key);
            return value;

        }else {
            return "";
        }




    }

    public static void main(String[] args) throws IOException {

        String proPath = "D:\\javaproject\\AutoTest\\WebAutoTest\\src\\main\\java\\com\\course\\muke" +
                "\\cases\\config\\element.properties";
        ProUtil pt = new ProUtil(proPath);
        String value = pt.getPro("loginbutton");
        System.out.println(value);

    }
}
