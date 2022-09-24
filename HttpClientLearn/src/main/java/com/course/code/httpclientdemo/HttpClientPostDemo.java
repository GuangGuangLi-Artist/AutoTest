package com.course.code.httpclientdemo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * httpclient发送application/x-www-form-urlencoded的post请求
 */
public class HttpClientPostDemo {

    @Test
    public void postForm(){

        String url = "http://localhost:8888/post/xwwwformurlencoded";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //发送post请求
        HttpPost post = new HttpPost(url);

        //给post对象设置参数
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("name","guangguang"));
        paramList.add(new BasicNameValuePair("password","guang"));

        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramList, Consts.UTF_8);
        post.setHeader("content-type","application/x-www-form-urlencoded; charset=utf-8");
        post.setHeader("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Mobile Safari/537.36");
        post.setEntity(formEntity);
        System.out.println(post.getURI());

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(post);
            HttpEntity responseEntity = response.getEntity();
            String resString = EntityUtils.toString(responseEntity);

            //将字符串转成json
            JSONObject jsonObject;
            jsonObject = JSONObject.parseObject(resString);
            System.out.println(jsonObject);
            EntityUtils.consume(responseEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpClient!= null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    //请求参数是json类型
    @Test
    public void postJson(){


        String url = "http://localhost:8888/post/json";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //发送post请求
        HttpPost post = new HttpPost(url);

        JSONObject json = new JSONObject();
        json.put("name","guangguangjson");
        json.put("password","guangjson");

        StringEntity jsonEntity = new StringEntity(json.toString(),Consts.UTF_8);



        jsonEntity.setContentType("application/json");
        jsonEntity.setContentEncoding(Consts.UTF_8.name());

        post.setHeader("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Mobile Safari/537.36");

        //设置请求参数
        post.setEntity(jsonEntity);
        System.out.println(post.getURI());


        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(post);
            HttpEntity responseEntity = response.getEntity();
            String resString = EntityUtils.toString(responseEntity,Consts.UTF_8);

            //将字符串转成json
            JSONObject jsonObject;
            jsonObject = JSONObject.parseObject(resString);
            System.out.println(jsonObject);
            EntityUtils.consume(responseEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpClient!= null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
