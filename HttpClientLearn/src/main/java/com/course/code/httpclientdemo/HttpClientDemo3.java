package com.course.code.httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 爬取网站上的图片
 *
 * 设置超时时间
 *
 *
 */

public class HttpClientDemo3 {

    @Test
    public void getImage(){

        //爬取网上一张图片到本地

        //String url = "https://pic.3gbizhi.com/2020/0914/thumb_200_0_20200914085444755.jpg";
        String url = "https://www.bing.com/?mkt=zh-CN";
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
        CloseableHttpResponse response = null;

        //设置访问代理
        String host = "api.vc.bilibili.com";
        int port = 443;
        HttpHost proxy = new HttpHost(host,port);

        //设置代理的地址
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        //设置超时时间setConnectTimeout
        //setSocketTimeout 读取时间 表示从请求的网址获得响应数据的时间间隔
        RequestConfig requestConfig1 = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(3000).build();

        get.setConfig(requestConfig1);

        try {
           response = closeableHttpClient.execute(get);
            HttpEntity httpEntity = response.getEntity();
           /* if(httpEntity.getContentType().getValue().contains("jpeg")){
                File desc = new File("F:\\ideaWorkspace\\AutoTest\\HttpClientLearn\\src\\main\\java\\com\\course\\code\\imagedesc\\copy.jpg");
                byte[] bytes = EntityUtils.toByteArray(httpEntity);
                FileOutputStream fos =new FileOutputStream(desc);
                fos.write(bytes);
                fos.close();
            }*/
            String lineRes = EntityUtils.toString(httpEntity);
            System.out.println(lineRes);
            //确保关闭httpEntity
            EntityUtils.consume(httpEntity);

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

            if(closeableHttpClient != null){
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
