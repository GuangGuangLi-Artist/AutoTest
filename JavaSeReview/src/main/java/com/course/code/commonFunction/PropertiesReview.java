package com.course.code.commonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReview {


    @Test
    public void testProperties() {
        Properties prop = new Properties();

        //相当于集合来使用
        Map<String,String > map = new HashMap<String,String >();
        map.put("张三","12");
        map.put("张是","13");
        map.put("张否","14");

        prop.putAll(map);
        prop.put("王五","15");

        FileReader fis = null;
        FileWriter fw = null;

        try {
           fis =  new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\javaSeProperties.properties", StandardCharsets.UTF_8);
            prop.load(fis);
            //添加配置
            prop.setProperty("sex","男");
            fw = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\FileDemo\\javaSeProperties.properties", StandardCharsets.UTF_8);
            prop.store(fw,"comments");


            System.out.println("-----------");
            //获取配置
            String name = prop.getProperty("name");
            System.out.println(name);

            //获取键的集合
            prop.stringPropertyNames().forEach(key -> System.out.println(key + "=" + prop.getProperty(key)));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (prop != null) {
                prop.clear();
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void testProperty() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/chromedriver.exe");
        Properties properties = System.getProperties();
        properties.forEach((x,y) -> System.out.println(x + "------" + y));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.close();



    }
}
