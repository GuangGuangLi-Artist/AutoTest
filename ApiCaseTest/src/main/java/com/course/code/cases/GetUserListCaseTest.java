package com.course.code.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.course.code.config.TestConfig;
import com.course.code.domain.GetUserInfoCase;
import com.course.code.domain.GetUserListCase;
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
import java.util.List;

public class GetUserListCaseTest {


    @Test(dependsOnGroups = "loginTrue",description = "获取用户列表")
    public void getUserList() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserListCase userListCase = session.selectOne("getUserListcase",1);
        System.out.println(userListCase.toString());
        System.out.println(TestConfig.getUserListUrl);


        JSONArray resultjson = getJsonResult(userListCase);

        List<User> userList = session.selectList(userListCase.getExpected(),userListCase);

        for (User user:userList){
            System.out.println("获取的User是" + user.toString());
        }

        JSONArray userListJson =  JSONArray.parseArray(JSON.toJSONString(userList));//将list转化为JSonarray
        Assert.assertEquals(userListJson.size(),resultjson.size());

        for (int i = 0; i < resultjson.size(); i++) {
            JSONObject expect = resultjson.getJSONObject(i);
            JSONObject actual = userListJson.getJSONObject(i);
            Assert.assertEquals(expect,actual);
        }

    }

    private JSONArray getJsonResult(GetUserListCase userListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("userName",userListCase.getUserName());
        param.put("sex",userListCase.getSex());
        param.put("age",userListCase.getAge());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        String result;

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONArray jsonArray = JSON.parseArray(result);
        return jsonArray;



    }
}
