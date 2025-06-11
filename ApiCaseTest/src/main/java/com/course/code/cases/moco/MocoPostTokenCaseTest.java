package com.course.code.cases.moco;

import com.alibaba.fastjson.JSONObject;
import com.course.code.config.TestConfig;
import com.course.code.domain.InterfaceName;
import com.course.code.domain.MocoPostCase;
import com.course.code.utils.ConfigFile;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MocoPostTokenCaseTest {
    //管理Cookie
    private static HttpClientContext context = null;
    private static String Authorization = "";

    @BeforeMethod
    public void beforeLoad(){
        TestConfig.mocoPostApiURL = ConfigFile.getMocoUrl(InterfaceName.MOCOPOSTURLENCODED);
        context = HttpClientContext.create();
        //登录获取Cookie
        Map<String,Object> cookieAndToken = MocoLoginUtils.loginSuccessMoco();
//        cookieAndToken.forEach((s,k) -> {
//            System.out.println(s + "-------" +k.toString());
//        });
        context.setCookieStore((CookieStore) cookieAndToken.get("cookie"));
        Authorization = (String) cookieAndToken.get("token");
        System.out.println("BeforeMethod 执行成功");


    }

    @Test
    public void testPostToken(){

        MocoPostCase mocoPostCase = new MocoPostCase();
        mocoPostCase.setName("guangguang");
        mocoPostCase.setPassword("guang");

        String res = postRes(mocoPostCase);
        System.out.println(res);
        JSONObject jsonObject = JSONObject.parseObject(res);

        String status = jsonObject.getString("status");
        Assert.assertEquals(status, "success");

    }

    private String postRes(MocoPostCase mocoPostCase) {


        //添加请求参数
        List<BasicNameValuePair> valuePairList = new ArrayList<BasicNameValuePair>();
        valuePairList.add(new BasicNameValuePair("name", mocoPostCase.getName()));
        valuePairList.add(new BasicNameValuePair("password", mocoPostCase.getPassword()));

        //设置参数编码
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(valuePairList, Consts.UTF_8);
        HttpPost httpPost = new HttpPost(TestConfig.mocoPostApiURL);
        httpPost.setHeader("Authorization", Authorization);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        httpPost.setEntity(urlEncodedFormEntity);
        CloseableHttpResponse response = null;
        String resString = "";

        try {
            response = TestConfig.defaultHttpClient.execute(httpPost,context);
            HttpEntity responseEntity = response.getEntity();
            resString = EntityUtils.toString(responseEntity, Consts.UTF_8);
            EntityUtils.consume(responseEntity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }



        return resString;
    }

    @AfterMethod
    public void testAfter() {
        context.removeAttribute(HttpClientContext.COOKIE_STORE);
        if (TestConfig.defaultHttpClient != null) {
            TestConfig.defaultHttpClient.close();
        }

        System.out.println("AfterMethod 执行成功");
    }


}
