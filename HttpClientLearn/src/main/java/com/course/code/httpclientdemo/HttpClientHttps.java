package com.course.code.httpclientdemo;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Connection;

/**
 * HttpClient请求https
 * 绕过https认证
 */
public class HttpClientHttps {




    @Test
    public void httpClientByPassHttps() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {


        //创建register
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", trustHttpCertificates())
                .build();
        //创建ConnectionManager对象
        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager(registry);


        //定制CloseableHttpClient
        HttpClientBuilder httpClientBuilder = HttpClients.custom().setConnectionManager(pool);

        CloseableHttpClient httpClient = httpClientBuilder.build();
        String uri = "https://www.baidu.com/";
        HttpGet get = new HttpGet(uri);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);

            HttpEntity httpEntity = response.getEntity();

            String resString = EntityUtils.toString(httpEntity);
            System.out.println(resString);
            EntityUtils.consume(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if( response != null ){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private ConnectionSocketFactory trustHttpCertificates() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {

        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
        sslContextBuilder.loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        });

        SSLContext sslContext = sslContextBuilder.build();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                sslContext,new String[]{"SSLv2Hello","SSLv3"},null, NoopHostnameVerifier.INSTANCE
        );



        return sslConnectionSocketFactory;
    }
}
