package com.course.code.httpclientdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class HttpClientPost {


    /**
     * 请求携带Cookie
     */

    private String url;


    //读取配置文件的方法类
    private ResourceBundle bundle;

    //用来存储Cookie信息的CookStore
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);

        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCook() throws IOException {

        String res;
        String uri = bundle.getString("getCookies.uri");
        DefaultHttpClient client = new DefaultHttpClient();
        String testUrl = this.url + uri;

        //测试逻辑代码
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        res = EntityUtils.toString(entity,"UTF-8");
        System.out.println(res);

        //获取Cookies
        this.cookieStore = client.getCookieStore();
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:" + name + " ;value:" +value);
        }

    }

    @Test(dependsOnMethods = {"testGetCook"})
    public void testPost() throws IOException {
        
        String uri = bundle.getString("test.postdemo.api1.cookies");
        String testUrl = this.url + uri;
        CloseableHttpClient client = HttpClients.createDefault();

        //添加post请求参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","dawei");
        jsonObject.put("age","28");



        //将参数添加到方法中
        StringEntity entity = new StringEntity(jsonObject.toString(),Consts.UTF_8);
        //设置请求头信息
        entity.setContentType("application/json");
        entity.setContentEncoding(Consts.UTF_8.name());

        HttpPost httpPost = new HttpPost(testUrl);
        //添加Cookie

        CookieStore cookieStore1 = this.cookieStore;
        List<Cookie> cookies = cookieStore1.getCookies();
        String cookieStr = "";
        for (Cookie cookie:cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            cookieStr = name + "=" + value;
        }

        httpPost.setHeader("Cookie",cookieStr);
        httpPost.setHeader("User-Agent","PostmanRuntime/7.43.0");

        httpPost.setEntity(entity);

        CloseableHttpResponse response = null;

        try {
            response = client.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            String res = EntityUtils.toString(responseEntity, Consts.UTF_8);
            System.out.println(res);

            JSONObject jsRes = JSON.parseObject(res);
            //判断结果
            String content = (String) jsRes.get("content");
            Assert.assertEquals("这是一个必须带有Cookies的post请求",content);
            EntityUtils.consume(responseEntity);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (response != null) {
                try {
                    response.close();
                }catch (Exception e){

                    e.printStackTrace();
                }
            }
        }
        try {
            if (client != null) {
                client.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testReviewPost() throws IOException {
        String uri = bundle.getString("test.postdemo.api2.review");
        String testUrl = this.url + uri;
        System.out.println(testUrl);

        CloseableHttpClient client = HttpClients.createDefault();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","su");
        jsonObject.put("password","biao");
        HttpPost httpPost = new HttpPost(testUrl);
        StringEntity entity = new StringEntity(jsonObject.toString(), Consts.UTF_8);
        httpPost.setHeader("Cookie","email=9999@123.com;login=success");
        entity.setContentType("application/json");
        entity.setContentEncoding(Consts.UTF_8.name());
        httpPost.setHeader("User-Agent","PostmanRuntime/7.43.0");

        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            HttpEntity entity1 = response.getEntity();
            String res = EntityUtils.toString(entity1, Consts.UTF_8);
            System.out.println(res);
            JSONObject jsRes = JSON.parseObject(res);
            JSONArray posts = jsRes.getJSONArray("posts");
            Object object = posts.get(0);
            String objectString = object.toString();
            JSONObject js = JSON.parseObject(objectString);
            String comm0 = js.getString("comm");
            Assert.assertEquals(comm0,"test1");


            String content = (String) jsRes.get("name");
            Assert.assertEquals(content,"zhangsan");

            EntityUtils.consume(entity1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(response != null){
               try {
                   response.close();
               }catch (Exception e){
                   e.printStackTrace();
               }

            }

        }
        if (client != null) {
            try {
                client.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }




    }

}
