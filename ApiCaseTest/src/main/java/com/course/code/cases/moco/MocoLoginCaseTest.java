package com.course.code.cases.moco;

import com.alibaba.fastjson.JSONObject;
import com.course.code.config.TestConfig;
import com.course.code.domain.InterfaceName;
import com.course.code.domain.MocoLoginCase;
import com.course.code.utils.ConfigFile;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MocoLoginCaseTest {

    @BeforeTest
    public void  beforeTest(){
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.updateUserUrl =ConfigFile.getUrl(InterfaceName.UPDATEUSER);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.mocologinUrl = ConfigFile.getMocoUrl(InterfaceName.MOCOLOGIN);
        TestConfig.defaultHttpClient = new DefaultHttpClient();

    }

    @Test
    public void mocoLoginTrue(){
        MocoLoginCase mocoLoginCase = new MocoLoginCase();
        mocoLoginCase.setName("guangguangjson");
        mocoLoginCase.setPassword("guangjson");

        String res = getResult(mocoLoginCase);
        System.out.println(res);

    }

    private String getResult(MocoLoginCase mocoLoginCase){
        HttpPost post = new HttpPost(TestConfig.mocologinUrl);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", mocoLoginCase.getName());
        jsonObject.put("password", mocoLoginCase.getPassword());
        StringEntity entity = new StringEntity(jsonObject.toJSONString(), Consts.UTF_8);
        entity.setContentType("application/json");
        post.setEntity(entity);

        CloseableHttpResponse response = null;
        String responseRes = "";
        try {
             response = TestConfig.defaultHttpClient.execute(post);
            HttpEntity responseEntity = response.getEntity();
            Header[] cookies = response.getHeaders("Set-Cookie");
            for (Header header : cookies) {
                System.out.println(header.getValue());
            }
            System.out.println(Arrays.toString(cookies));
            responseRes = EntityUtils.toString(responseEntity, Consts.UTF_8);
            TestConfig.cookieStore  = TestConfig.defaultHttpClient.getCookieStore();
            System.out.println(TestConfig.cookieStore.toString());


            EntityUtils.consume(responseEntity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (TestConfig.defaultHttpClient != null) {
                TestConfig.defaultHttpClient.close();
            }
        }

        return  responseRes;
    }
}
