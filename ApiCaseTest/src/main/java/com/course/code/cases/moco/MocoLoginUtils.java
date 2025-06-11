package com.course.code.cases.moco;

import com.alibaba.fastjson.JSONObject;
import com.course.code.config.TestConfig;
import com.course.code.domain.InterfaceName;
import com.course.code.domain.MocoLoginCase;
import com.course.code.utils.ConfigFile;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MocoLoginUtils {

    public static Map<String,Object> loginSuccessMoco(){
        TestConfig.mocologinUrl = ConfigFile.getMocoUrl(InterfaceName.MOCOLOGIN);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(TestConfig.mocologinUrl);

        MocoLoginCase mocoLoginCase = new MocoLoginCase();
        mocoLoginCase.setName("guangguangjson");
        mocoLoginCase.setPassword("guangjson");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", mocoLoginCase.getName());
        jsonObject.put("password", mocoLoginCase.getPassword());
        StringEntity entity = new StringEntity(jsonObject.toJSONString(), Consts.UTF_8);
        entity.setContentType("application/json");
        post.setEntity(entity);

        Map<String,Object> resMap = new HashMap<String,Object>();
        CloseableHttpResponse response = null;
        TestConfig.cookieStore = null;
        try {
            response = TestConfig.defaultHttpClient.execute(post);
            HttpEntity responseEntity = response.getEntity();
            Header[] tokens = response.getHeaders("token");
            Header token = tokens[0];
//            String responseRes = EntityUtils.toString(responseEntity, Consts.UTF_8);

            TestConfig.cookieStore  = TestConfig.defaultHttpClient.getCookieStore();
//            System.out.println(TestConfig.cookieStore.toString());

            resMap.put("token", token.getValue());
            resMap.put("cookie", TestConfig.defaultHttpClient.getCookieStore());
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
        }

        return  resMap;
    }
}
