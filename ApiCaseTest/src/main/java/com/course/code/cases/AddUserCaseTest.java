package com.course.code.cases;

import com.alibaba.fastjson.JSONObject;
import com.course.code.config.TestConfig;
import com.course.code.domain.AddUserCase;
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

public class AddUserCaseTest {



    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口测试")
    public void addUser() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());//{id=1, userName='李四', password='123456', sex='男', age='28', permission='0', isDelete='1', expected='true'}
        System.out.println(TestConfig.addUserUrl);//http://localhost:8083/v1/addUser
        //1, heh, 123, 15, 男, true, 1, true


        //发请求获取结果
        String result = getResult(addUserCase);//true
        Thread.sleep(5000);
      //{id=1, userName='李四', password='123456', sex='男', age='28', permission='0', isDelete='1', expected='true'}
        User user = session.selectOne("addUser",addUserCase);
        System.out.println(user.toString());
        //验证返回结果
        Assert.assertEquals(addUserCase.getExpected(),result);

    }

    private String getResult(AddUserCase addUserCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("age",addUserCase.getAge());
        param.put("sex",addUserCase.getSex());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());

        //设置头信息
        post.setHeader("content-type","application/json");

        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);

        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);//true



        return result;
    }



}
