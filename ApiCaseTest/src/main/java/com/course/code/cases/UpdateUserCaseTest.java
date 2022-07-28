package com.course.code.cases;

import com.course.code.config.TestConfig;
import com.course.code.domain.UpdateUserCase;
import com.course.code.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserCaseTest {

    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息")
    public void updateUser() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserCase updateUserCase = session.selectOne("updateUser",1);
        System.out.println(updateUserCase.toString());
        System.out.println(TestConfig.updateUserUrl);

    }

    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
    public void deleteUser() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserCase updateUserCase = session.selectOne("deleteUser",2);
        System.out.println(updateUserCase.toString());
        System.out.println(TestConfig.updateUserUrl);

    }
}
