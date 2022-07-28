package com.course.code.controller;


import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@RequestMapping("/v1")
@Api(value = "v1",description = "用户管理系统")
public class UserManager {


}
