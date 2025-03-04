package com.course.code.hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/hello")
    @ResponseBody
   public  String home(){
        return "Hello SpringBoot";
    }

    public static void main(String[] args) {
        try {
            SpringApplication.run(SampleController.class,args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
