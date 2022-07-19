package com.course.code.httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.*;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class HttpClientCookies {


    /**
     * 请求携带Cookie
     */

    private String url;


    //读取配置文件的方法类
    private ResourceBundle bundle;

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
        CookieStore store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:" + name + " ;value:" +value);
        }

    }
}
