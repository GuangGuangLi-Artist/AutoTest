package com.course.code.cases.moco;

import com.course.code.config.TestConfig;
import com.course.code.domain.InterfaceName;
import com.course.code.domain.MocoGetCase;
import com.course.code.domain.MocoLoginCase;
import com.course.code.utils.ConfigFile;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.course.code.domain.InterfaceName.MOCOGET;

public class MocoGetWithCookieCaseTest {

    private static  HttpClientContext context = null;

    @BeforeTest
    public void testLoad(){
        TestConfig.mocoGetApiURL = ConfigFile.getMocoUrl(MOCOGET);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        System.out.println("BeforeTest  执行了");

    }

    @BeforeMethod
    public void loginBefore() {
        context = HttpClientContext.create();
        CookieStore cookieStore = MocoLoginUtils.loginSuccessMoco();
        context.setCookieStore(cookieStore);
//        TestConfig.defaultHttpClient.setCookieStore(cookieStore);
        System.out.println("BeforeMethod  执行了");


    }

    @Test
    public void testMocoGet() {
        MocoGetCase mocoGetCase = new MocoGetCase();
        mocoGetCase.setName("getWithLi");
        mocoGetCase.setPassword("123321");
        mocoGetCase.setPostType("comment");

        try {
            String res = getRes(mocoGetCase);
            System.out.println(res);
            boolean success = res.contains("success");
            Assert.assertEquals(success, true);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


    }

    private String getRes(MocoGetCase mocoGetCase) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(TestConfig.mocoGetApiURL);
        uriBuilder.addParameter("name", mocoGetCase.getName());
        uriBuilder.addParameter("password", mocoGetCase.getPassword());
        uriBuilder.addParameter("postType", mocoGetCase.getPostType());

        URI uri = uriBuilder.build();
        HttpGet get = new HttpGet(uri);
        CloseableHttpResponse response = null;
        String resBody = "";

        try {
            response = TestConfig.defaultHttpClient.execute(get,context);
            HttpEntity responseEntity = response.getEntity();
            resBody = EntityUtils.toString(responseEntity, Consts.UTF_8);
            EntityUtils.consume(responseEntity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if(TestConfig.defaultHttpClient != null) {
                TestConfig.defaultHttpClient.close();
            }
        }



        return resBody;
    }


}
