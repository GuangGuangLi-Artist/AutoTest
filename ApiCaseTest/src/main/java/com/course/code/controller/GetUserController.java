package com.course.code.controller;

import com.course.code.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Log4j
@RestController
@Api(value = "/v1",description = "第一个版本的demo")
@RequestMapping("/v1")
public class GetUserController {



    @Autowired//代表启动就加载SqlSessionTemplate
    private SqlSessionTemplate template;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户个数",httpMethod = "get")
    public int getUserList(){

        Integer usercount = userService.getUserCount();
        return usercount;


    }
}
