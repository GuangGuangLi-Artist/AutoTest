package com.course.code.controller;

import com.course.code.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Log4j
@RestController
@Api(value = "v1",description = "用户管理系统")
@RequestMapping("/v1")
public class UserManager {

    //http://localhost:8083/swagger-ui.html#!/user-manager/

    @Autowired
    private SqlSessionTemplate template;

    @ApiOperation(value = "登录接口",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response, @RequestBody User user){

        int i = template.selectOne("login",user);//查询传入的user信息是不是在数据库中存在
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        log.info("查询到的结果是" + i);
        if(i==1){
            log.info("登录的用户是：" + user.getUserName());
            return true;
        }
        return false;


    }
    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(HttpServletRequest request,@RequestBody User user){

        Boolean x = verifyCookies(request);
        int result =0;
        if(x!=null){
            result = template.insert("addUser",user);
//            template.commit(true);
        }
        if(result>0){
            log.info("添加用户的数量是：" + result);
            return true;
        }
        return false;

    }

    @ApiOperation(value = "获取用户信息接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);
        if(x==true){
            List<User> userList = template.selectList("getUserInfo",user);
            log.info("getUserInfo获取到的用户数量是" + userList.size());
            return userList;
        }else {
            return null;
        }
    }
    @ApiOperation(value = "更新或者删除用户接口",httpMethod = "POST")
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);
        int i = 0;
        if(x==true){
            i = template.update("updateUserInfo",user);

        }
        log.info("更新数据的条目数：" + i);
        return i;

    }

    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            log.info("cookies为空");
            return  false;
        }

        for (Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                log.info("cookie验证通过");
                return  true;
            }

        }
        return false;
    }
}
