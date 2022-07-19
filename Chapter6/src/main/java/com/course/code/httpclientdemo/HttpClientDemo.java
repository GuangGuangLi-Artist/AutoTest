package com.course.code.httpclientdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientDemo {


    @Test
    public void httpTest1() throws IOException {
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity,"UTF-8");
        System.out.println(result);


    }
}
