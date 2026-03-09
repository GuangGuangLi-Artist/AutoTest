package com.testNgExample.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {


    // 【核心知识点】ThreadLocal 保证线程隔离
    // 每个线程调用 get() 时，都会获取属于该线程独立的 WebDriver 实例

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        WebDriver driver = threadLocalDriver.get();
        return driver;
    }

    public static void initDriver() {
        // 1. 如果当前线程已经有驱动了，直接返回，不要重复创建
        if (threadLocalDriver.get() != null) {
            return;
        }
        System.out.println("[" + Thread.currentThread().getName() + "] 正在初始化浏览器...");


        // 自动管理驱动版本
        try {
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox"); // 增加沙箱禁用，防止某些环境启动失败
            options.addArguments("--disable-dev-shm-usage"); // 解决共享内存问题
            options.addArguments("--window-size=1920,1080");

            long startTime = System.currentTimeMillis();
            WebDriver webDriver = new ChromeDriver(options);
            long endTime = System.currentTimeMillis();
            System.out.println("[" + Thread.currentThread().getName() + "] ChromeDriver 创建耗时: " + (endTime - startTime) + "ms");
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.manage().window().maximize();

            threadLocalDriver.set(webDriver);
            System.out.println("[" + Thread.currentThread().getName() + "] 浏览器启动成功！");
        } catch (Exception e) {
            System.err.println("[" + Thread.currentThread().getName() + "] 浏览器启动失败！");
            e.printStackTrace();
            throw new RuntimeException("无法初始化 WebDriver: " + e.getMessage(), e);
        }


    }


    public static void quitDriver() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            try {
                System.out.println("[" + Thread.currentThread().getName() + "] 正在关闭浏览器...");
                driver.quit();
                System.out.println("[" + Thread.currentThread().getName() + "] 浏览器已关闭");
            } catch (Exception e) {
                System.err.println("[" + Thread.currentThread().getName() + "] 关闭浏览器时出错: " + e.getMessage());
            } finally {
                // 无论是否成功关闭，都要移除引用
                threadLocalDriver.remove();
                System.out.println("[" + Thread.currentThread().getName() + "] ThreadLocal 已清理");
            }
        } else {
            System.out.println("[" + Thread.currentThread().getName() + "] 无需关闭，Driver 为空");
        }
    }

}
