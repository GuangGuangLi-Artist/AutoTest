package com.course.code.cases;

import com.course.code.config.TestConfig;
import com.course.code.domain.InterfaceName;
import com.course.code.domain.LoginCase;
import com.course.code.utils.ConfigFile;
import com.course.code.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {


    @BeforeTest(groups = "loginTrue",description = "测试准备工作")
    public void beforeTest(){

        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.updateUserUrl =ConfigFile.getUrl(InterfaceName.UPDATEUSER);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.defaultHttpClient = new DefaultHttpClient();


    }


    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("logingCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

    }

    @Test(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("logingCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

    }

}
