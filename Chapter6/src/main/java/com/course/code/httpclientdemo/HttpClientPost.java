package com.course.code.httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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
        HttpPost httpPost = new HttpPost(testUrl);

        //添加post请求参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","dawei");
        jsonObject.put("age","28");

        //设置请求头信息
        httpPost.setHeader("content-type","application/json;charset=UTF-8");
        //将参数添加到方法中
        StringEntity entity = new StringEntity(jsonObject.toString(),"UTF-8");
        httpPost.setEntity(entity);


        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.cookieStore);
        CloseableHttpResponse response = client.execute(httpPost);
        String res = EntityUtils.toString(response.getEntity(), "UTF-8");

        //将String res 转化为 Json

        JSONObject jsRes = new JSONObject(res);


        //判断结果
        String content = (String) jsRes.get("content");
        System.out.println(jsRes);
        Assert.assertEquals("这是一个必须带有Cookies的post请求",content);


    }
}
