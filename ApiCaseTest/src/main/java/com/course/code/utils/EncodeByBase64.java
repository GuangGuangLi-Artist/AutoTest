package com.course.code.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncodeByBase64 {

    //加密
    public String getEncodeByBase64(String str) throws UnsupportedEncodingException {
        Base64.Encoder encoder = Base64.getEncoder();

        byte[] textBytes = str.getBytes("UTF-8");
        String res= encoder.encodeToString(textBytes);

        return res;
    }

    public String getDecodeByBase64(String str) throws UnsupportedEncodingException {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] textBytes = str.getBytes("UTF-8");
        String res= new String(decoder.decode(textBytes));

        return res;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        EncodeByBase64 encodeByBase64 = new EncodeByBase64();
        String base64su = encodeByBase64.getEncodeByBase64("subiaoBack");
        System.out.println(base64su);

        //解密
        String decodeByBase64 = encodeByBase64.getDecodeByBase64(base64su);
        System.out.println(decodeByBase64);


    }


    public void test() {
    }
}
