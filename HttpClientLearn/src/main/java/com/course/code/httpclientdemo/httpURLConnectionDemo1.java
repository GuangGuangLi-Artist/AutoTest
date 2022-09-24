package com.course.code.httpclientdemo;


import org.testng.annotations.Test;

import javax.xml.bind.annotation.XmlAnyAttribute;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * httpURLConnection学习类
 */
public class httpURLConnectionDemo1 {


    /**
     * jdk原生API请求网页
     */

    @Test
    public void test() throws IOException {
        String urlstr = "https://www.baidu.com/";
        URL url = new URL(urlstr);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        //HttpURLConnection httpURLConnection1 = (HttpURLConnection)url.openConnection();

        //设置请求类型
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept-Charset","utf-8");

        //获取httpURLConnection的输入流
        InputStream is = httpURLConnection.getInputStream();
        InputStreamReader isp = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isp);

        String line = null;
        while ((line =br.readLine()) != null){
            System.out.println(line);
        }



    }


}
