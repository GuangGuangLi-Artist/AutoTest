package com.course.code.springdevelop;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class SpringBootGet {


    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "可以成功获取Cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "成功获取Cookies";
    }

    /**
     * 要求携带cookies访问
     */

    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "必须携带cooke才能访问成功",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){


        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "必须携带cooke才能访问成功";
        }


        return "1+1=2";





    }

    /**
     * 携带参数的get请求
     */
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    @ApiOperation(value = "必须携带参数的方法1",httpMethod = "GET")
    public Map<String,String> getList(@RequestParam Integer start,@RequestParam Integer end){

        Map<String,String> listmap = new HashMap<>();
        listmap.put("小浣熊","往前飞");
        listmap.put("nike","苏菲");
        listmap.put("addidas","苏表");

        return listmap;

    }

    /**
     * 携带参数访问的get请求
     */

    @RequestMapping(value = "/getMap/{start}/{end}")
    @ApiOperation(value = "必须携带参数的方法2",httpMethod = "GET")
    public Map<String,String> getMap(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,String> listmap = new HashMap<>();
        listmap.put("speak","soft");
        listmap.put("nike","放牛班的春天");
        listmap.put("addidas","流人");
        return listmap;

    }


}
