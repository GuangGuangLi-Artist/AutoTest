package com.course.code.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//托管给SpringBoot
@SpringBootApplication
@ComponentScan("com.course.code")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }



}
