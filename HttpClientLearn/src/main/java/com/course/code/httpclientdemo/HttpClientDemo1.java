package com.course.code.httpclientdemo;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * HttpClientDemo
 * 发送Get无参请求
 * 带有请求头
 * 有参的情况，需要urlEncode
 * 获取响应头及相应的API的认识
 */
public class HttpClientDemo1 {
    
    
    @Test
    public void httpClientGet() throws Exception {

        //创建默认的可关闭的httpclient,类似一个打开的浏览器窗口
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "https://www.baidu.com/";
        String ageparam = "29";
        //String ageparam = "290";

        //做URLEncoder
        ageparam= URLEncoder.encode(ageparam,StandardCharsets.UTF_8.name());
        String moocGetWithParam = "http://localhost:8888/getwithparamdemo?name=subiao&age="+ageparam;

        //创建一个httpGet对象
        //HttpGet httpGet = new HttpGet(moocGetWithParam);
        HttpGet httpGet = new HttpGet(url);

        //添加请求头
        httpGet.addHeader("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Mobile Safari/537.36");

        //http://localhost:8888/getwithparamdemo?name=苏表&age=123%2Babc+456+%7C178
        System.out.println(httpGet.getURI());

        //创建CloseableHttpResponse对象 接受请求响应
        CloseableHttpResponse response = null;

        try {
            //使用httpClient请求网址
         response = httpClient.execute(httpGet);

         //获取响应状态
            StatusLine statusLine = response.getStatusLine();

         if(HttpStatus.SC_OK == statusLine.getStatusCode()){
             //获取响应头
             Header[] headers = response.getAllHeaders();
             for (Header header:headers){
                 System.out.println(header.getName() + "===" +  header.getValue());
             }


             //响应实体内容
             //httpEntity不仅可以作为结果，还可以作为请求的参数实体，有很多的实现
             HttpEntity httpEntity = response.getEntity();

             //获取响应的Content-Type
             System.out.println("ContentType: " + httpEntity.getContentType());

             //使用EntityUtils处理响应结果
             String stringResult = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
             System.out.println(stringResult);

             //确保关闭httpEntity流关闭
             EntityUtils.consume(httpEntity);
         }else {
             System.out.println("响应失败，响应码"+statusLine.getStatusCode());
         }




        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if(response != null){

                try {
                    //关闭响应response
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(httpClient != null){
                try {
                    //确保CloseableHttpClient关闭
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }


}
