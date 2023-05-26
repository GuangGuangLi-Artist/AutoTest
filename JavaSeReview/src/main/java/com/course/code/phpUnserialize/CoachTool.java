package com.course.code.phpUnserialize;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.phprpc.util.AssocArray;
import org.phprpc.util.Cast;
import org.phprpc.util.PHPSerializer;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class CoachTool {

    public List<String> unserializePHParray(String content){
        List<String> list = new ArrayList<String>();
        PHPSerializer p = new PHPSerializer();
        if (StringUtils.isEmpty(content))
            return list;
        try {
            AssocArray array = (AssocArray) p.unserialize(content.getBytes());
            for (int i = 0; i < array.size(); i++) {
                String t = (String) Cast.cast(array.get(i), String.class);
                list.add(t);
            }
        }catch (Exception e){
            System.out.println("反序列化PHParray: " + content + " 失败！！！" );
        }
        return list;
    }


    // https://blog.csdn.net/netuser1937/article/details/121206500
    //https://blog.csdn.net/cxclll/article/details/125788362
    public JSONObject unserializePHPJsonObject(String content){
        JSONObject jsonObject = new JSONObject();
        PHPSerializer p = new PHPSerializer();

        if (StringUtils.isEmpty(content))
            return jsonObject;
        try {
            HashMap<String,String>  hashMap= (HashMap<String, String>) p.unserialize(content.getBytes("utf-8"), Map.class);
            for (String key: hashMap.keySet()){
                jsonObject.put(key,hashMap.get(key));
            }
           return jsonObject;

        }catch (Exception e){
            System.out.println("反序列化PHParray: " + content + " 失败！！！" );
        }
        return jsonObject;
    }


//    public JSONObject unserializePHPJsonObject1(String content){
//        JSONObject jsonObject = new JSONObject();
//        PHPSerializer p = new PHPSerializer();
//
//        if (StringUtils.isEmpty(content))
//            return jsonObject;
//        try {
//            AssocArray array = (AssocArray) p.unserialize(content.getBytes(StandardCharsets.UTF_8));
//            HashMap<String,String> hashMap = array.toHashMap();
//
//            for (String key: hashMap.keySet()){
//
//                if(hashMap.get(key) instanceof byte[]){
//
//                }
//                jsonObject.put(key,hashMap.get(key).getBytes(StandardCharsets.UTF_8).toString());
//            }
//            return jsonObject;
//
//        }catch (Exception e){
//            System.out.println("反序列化PHParray: " + content + " 失败！！！" );
//        }
//        return jsonObject;
//
//}



}
