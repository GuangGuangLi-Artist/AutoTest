package com.course.code.test.controller;


import com.alibaba.fastjson.JSONObject;
import com.course.code.test.domain.User;
import com.course.code.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j
@RestController
@Api(value = "/v1",description = "第一个版本的demo")
@RequestMapping("/v1")
public class GetUserCount {

    @Autowired//代表启动就加载SqlSessionTemplate
    private SqlSessionTemplate template;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户个数",httpMethod = "get")
    public int getUserList(){

        Integer usercount = userService.getUserCount();
        return usercount;

       //return  template.selectOne("getUserCount");

    }


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加user",httpMethod = "post")
    public void addUser(@RequestBody User user){
       userService.addUser(user);
    }


    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "更新user",httpMethod = "post")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }


    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    @ApiOperation(value = "刪除user",httpMethod = "GET")
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }

    //获取用户列表
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有用户信息",httpMethod = "GET")
    public List<User> getAllUser() {
        List<User> userList = userService.getAllUser();
        for (User u:userList){
            System.out.println(u);
        }
        return  userList;
    }






}
