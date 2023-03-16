package com.GuangGuangLi.controller;

import com.GuangGuangLi.entity.UserInfo;
import com.GuangGuangLi.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IuserService iuserService;

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestParam("id") int id){
        UserInfo userInfo = iuserService.getUserInfo(id);
        return userInfo;
    }
}
