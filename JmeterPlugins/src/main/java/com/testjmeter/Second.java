package com.testjmeter;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Second  implements JavaSamplerClient {

    private static final String URLNAME="URL";
    private static final String DEFAULTURL="http://www.baidu.com/";
    private String inputUrl;
    private String resultData;

    @Override
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        inputUrl = javaSamplerContext.getParameter(URLNAME,DEFAULTURL);
        System.out.println("插件运行的url: " +inputUrl);


    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

        SampleResult result = new SampleResult();
        StringBuffer sb = new StringBuffer();

        try {
            URL url = new URL(inputUrl);
            URLConnection connection = url.openConnection();
            byte[] buffffer = new byte[1024];
            int len;

            result.sampleStart();//标记事务开始
            InputStream stream = connection.getInputStream();
            while( (len=stream.read(buffffer))!=-1){
                resultData = new String(buffffer,"UTF-8");
                sb.append(resultData);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        resultData = sb.toString();
        result.setSampleLabel("自定义的java请求");
        result.setSuccessful(true);
        result.setResponseData(resultData);
        result.setDataType(SampleResult.TEXT);
        return result;
    }

    @Override
    public void teardownTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("teardownTest run");

    }

    @Override
    public Arguments getDefaultParameters() {
        Arguments argument = new Arguments();
        argument.addArgument(URLNAME,DEFAULTURL);
        System.out.println("argument run");
        return argument;
    }
}
