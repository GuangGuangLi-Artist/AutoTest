package com.course.code.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

//托管给SpringBoot
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages ={"com.course.code.test.dao"})
@ComponentScan(basePackages = {"com.course.code"})
public class Application {



    private static ConfigurableApplicationContext context;
    public static void main(String[] args) {

        //SpringApplication.run(Application.class,args);
        Application.context = SpringApplication.run(Application.class,args);
    }

    @PreDestroy
    public void close(){
        Application.context.close();
    }



}
