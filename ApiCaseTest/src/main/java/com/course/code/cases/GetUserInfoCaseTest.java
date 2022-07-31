package com.course.code.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.course.code.config.TestConfig;
import com.course.code.domain.GetUserInfoCase;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserInfoCaseTest {


    @Test(dependsOnGroups = "loginTrue",description = "获取用户信息")
    public void getUserInfo() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();

        GetUserInfoCase userInfoCase = session.selectOne("getUserInfoCase",1);
        System.out.println(userInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);


        JSONArray resultJson = getJsonResult(userInfoCase);
        User user = session.selectOne(userInfoCase.getExpected(),userInfoCase);//1, 张三, 123456, 20, 男, true, 0

        List<User> userList = new ArrayList();
        userList.add(user);
        System.out.println(userList);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(userList));//[{"password":"123456","isDelete":"0","sex":"男","permission":"true","id":1,"userName":"张三","age":"20"}]

        Assert.assertEquals(jsonArray,resultJson);



    }

    private JSONArray getJsonResult(GetUserInfoCase userInfoCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("id",userInfoCase.getUserId());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        List resultList = Arrays.asList(result);

        JSONArray array = JSONArray.parseArray(JSON.toJSONString(resultList));

        return array;




    }


}
