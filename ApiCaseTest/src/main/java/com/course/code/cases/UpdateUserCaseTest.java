package com.course.code.cases;

import com.alibaba.fastjson.JSONObject;
import com.course.code.config.TestConfig;
import com.course.code.domain.UpdateUserCase;
import com.course.code.domain.User;
import com.course.code.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserCaseTest {

    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息")
    public void updateUser() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserCase updateUserCase = session.selectOne("updateUsercase",1);
        System.out.println(updateUserCase.toString());
        System.out.println(TestConfig.updateUserUrl);
        
        
        int result = getResult(updateUserCase);
        User user = session.selectOne(updateUserCase.getExpected(),updateUserCase);

        Assert.assertNotNull(user);
        Assert.assertNotNull(result);


    }

    private int getResult(UpdateUserCase updateUserCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.updateUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",updateUserCase.getUserName());
        param.put("sex",updateUserCase.getSex());
        param.put("age",updateUserCase.getAge());
        param.put("permission",updateUserCase.getPermission());
        param.put("isDelete",updateUserCase.getIsDelete());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result  = EntityUtils.toString(response.getEntity(),"utf-8");
        return Integer.parseInt(result);
    }

    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
    public void deleteUser() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserCase updateUserCase = session.selectOne("deleteUserCase",2);
        System.out.println(updateUserCase.toString());
        System.out.println(TestConfig.updateUserUrl);

    }
}
