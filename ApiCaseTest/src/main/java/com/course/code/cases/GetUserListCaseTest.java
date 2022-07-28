package com.course.code.cases;

import com.course.code.config.TestConfig;
import com.course.code.domain.GetUserListCase;
import com.course.code.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserListCaseTest {


    @Test(dependsOnGroups = "loginTrue",description = "获取用户列表")
    public void getUserList() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserListCase userListCase = session.selectOne("getUserList",1);
        System.out.println(userListCase.toString());
        System.out.println(TestConfig.getUserListUrl);

    }
}
