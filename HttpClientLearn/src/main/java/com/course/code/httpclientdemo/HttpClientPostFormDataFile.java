package com.course.code.httpclientdemo;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * HttpClient请求头的使用
 */
public class HttpClientPostFormDataFile {

    @Test
    public void postFormData(){
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://localhost:8080/UploadLearn2";
        HttpPost post = new HttpPost(url);

        //设置请求头
        //post.setHeader("Content-Type","multipart/form-data");


        //设置参数请求体
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        nameValuePairList.add(new BasicNameValuePair("username","xxxxx"));


        //设置文件请求体
        FileBody body = new FileBody(new File("F:\\ideaWorkspace\\AutoTest\\HttpClientLearn\\src\\main\\java\\com\\course\\code\\imagedesc\\copy.jpg"));


        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setContentType(ContentType.MULTIPART_FORM_DATA);
        multipartEntityBuilder.setCharset(StandardCharsets.UTF_8);
        multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        multipartEntityBuilder.addPart("zhaopian",body);
        multipartEntityBuilder.addTextBody("username", "xxx");
        HttpEntity entity = multipartEntityBuilder.build();

        post.setEntity(entity);

        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(post);
            HttpEntity responseEntity = response.getEntity();
            String res = EntityUtils.toString(responseEntity);
            System.out.println(res);



        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
