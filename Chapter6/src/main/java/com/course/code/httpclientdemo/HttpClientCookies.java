package com.course.code.httpclientdemo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
    public void testgetWithCookies() throws IOException {

        //拼接url
        String api2 = bundle.getString("test.getdemo.api2.cookies");
        String urlapi2 = this.url + api2;

        //请求
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(urlapi2);
        client.setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity, "UTF-8");
        System.out.println(res);

    }


    @Test
    public void testGetReview() throws IOException, URISyntaxException {
        //拼接url
        String apiget = bundle.getString("test.getdemo.api1.cookies");
        String urlGetReview = this.url + apiget;

        //请求
        DefaultHttpClient client = new DefaultHttpClient();
        URIBuilder uriBuilder = new URIBuilder(urlGetReview);
        //添加请求参数
        uriBuilder.addParameter("name","getWithLi");
        uriBuilder.addParameter("password","123321");
        uriBuilder.addParameter("postType","comment");
        URI uri = uriBuilder.setParameter("name","getWithLi").setParameter("password","123321")
                .setParameter("postType","comment").build();
        HttpGet get = new HttpGet(uri);
        System.out.println(uri.toString());
        //添加请求Cookie
        get.addHeader(new BasicHeader("Cookie","email=9999@123.com;login=success"));
        // 发送请求
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();

        //接受请求
        String res = EntityUtils.toString(entity, "UTF-8");
        System.out.println(res);

        //json结果编译
        JSONObject resJson = JSONObject.parseObject(res);
        String content = resJson.getString("content");

        //断言
        Assert.assertEquals(content,"success");

    }

    @Test
    public void testGetWirhParam()  {

        // 加载配置文件中的url
        String uri = bundle.getString("test.getdemo.api1.cookies");
        String getDemoUrl = this.url + uri;

        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();



        //构建参数列表
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("name","getWithLi"));
        params.add(new BasicNameValuePair("password","123321"));
        params.add(new BasicNameValuePair("postType","comment"));

        //设置参数编码
        UrlEncodedFormEntity form = new UrlEncodedFormEntity(params, Consts.UTF_8);

        String formToString;
        try {
            formToString  = EntityUtils.toString(form, Consts.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //创建httpGet
        HttpGet get = new HttpGet(getDemoUrl + "?" + formToString);

        get.setHeader("Cookie","email=9999@123.com;login=success");
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            String res = EntityUtils.toString(entity, "UTF-8");
            JSONObject resJson = JSONObject.parseObject(res);
            String content = resJson.getString("content");
            Assert.assertEquals(content,"success");


            EntityUtils.consume(entity);
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
        if (httpClient != null) {

            try {
                httpClient.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }



    }
}
