package com.course.code.cases;

import com.course.code.config.TestConfig;
import com.course.code.domain.GetUserInfoCase;
import com.course.code.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoCaseTest {


    @Test(dependsOnGroups = "loginTrue",description = "获取用户信息")
    public void getUserInfo() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();

        GetUserInfoCase userInfoCase = session.selectOne("getUserInfo",1);
        System.out.println(userInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);


    }
}
