package com.course.code.utils;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SetUp {

    public void setProperty(){
        System.setProperty("webdriver.chrome.driver","F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
    }

    public static String getBaseUrl(){
        Properties properties = new Properties();
        String baseUrl = null;


        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream("src\\main\\java\\com\\course\\code\\datas\\baseUrl.properties"));
            properties.load(inputStream);
            baseUrl = properties.getProperty("baseUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseUrl;

    }

    public static ChromeOptions setChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        return options;
    }
}
