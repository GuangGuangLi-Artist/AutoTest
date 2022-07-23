package com.course.code.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication//托管给SpringBoot
@ComponentScan("com.course.code.springdevelop")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }



}
