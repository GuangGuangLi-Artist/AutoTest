
package com.gpt.utils;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class HttpUtils {
    public static String doGet(String url, Map<String, String> headers) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        if (headers != null) headers.forEach(get::addHeader);
        return EntityUtils.toString(client.execute(get).getEntity());
    }

    public static String doPostJson(String url, Map<String, String> headers, String jsonBody) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        if (headers != null) headers.forEach(post::addHeader);
        post.setEntity(new StringEntity(jsonBody, "UTF-8"));
        return EntityUtils.toString(client.execute(post).getEntity());
    }

    public static String doDelete(String url, Map<String, String> headers) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete delete = new HttpDelete(url);
        if (headers != null) headers.forEach(delete::addHeader);
        return EntityUtils.toString(client.execute(delete).getEntity());
    }

    public static String doPut(String url, Map<String, String> headers, String body) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut put = new HttpPut(url);
        if (headers != null) headers.forEach(put::addHeader);
        put.setEntity(new StringEntity(body, "UTF-8"));
        return EntityUtils.toString(client.execute(put).getEntity());
    }
}
