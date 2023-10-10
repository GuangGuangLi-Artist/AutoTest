package com.course.code.springdevelop;


import com.alibaba.fastjson.JSONObject;
import com.course.code.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description="这是我全部的post接口")
@RequestMapping("/v1")
public class SpringBootPost {

    //这个变量是用来装我们的cookies信息的
    private static Cookie cookie;


    //用户登录成功获取到Cookies,然后再访问其他接口获取到列表

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口",httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam(value = "username",required = true) String username
                        ,@RequestParam(value ="password",required = true) String password){

        if(username.equals("张三")&&password.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);

        }
        return "登录成功";


    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表接口",httpMethod = "POST")
    public String getUserList(HttpServletRequest httpServletRequest, @RequestBody User user){

        Cookie[] cookies = httpServletRequest.getCookies();

        User user1 = new User();
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("login")&& cookie.getValue().equals("true" )&& user.getUsername().equals("张三") && user.getPassword().equals("123456")){
                user1.setUsername("马达叫");
                user1.setPassword("111111");
                user1.setAge("35");
                user1.setSex("男");
                JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user1);
                System.out.println(jsonObject);
                return user1.toString();





            }
        }


        return "参数不合法";

    }





}
