package com.course.code.phpUnserialize;


import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class UsePhp {
    public static void main(String[] args) {
        //String s = "a:3:{s:12:\"参与人数\";s:5:\"23266\";s:6:\"姓名\";s:3:\"hhh\";s:6:\"手机\";s:11:\"13432333433\";}";
        String content ="a:10:{i:0;s:18:\"舞蹈（私教）\";i:1;s:5:\"Zumba\";i:2;s:12:\"完美塑造\";i:3;s:12:\"战斗有氧\";i:4;s:12:\"杠铃雕塑\";i:5;s:12:\"核心特训\";i:6;s:12:\"漫步舞林\";i:7;s:12:\"身体平衡\";i:8;s:12:\"高效冲击\";i:9;s:12:\"魅力热舞\";}";
        CoachTool tool = new CoachTool();
        List<String> reusltList = tool.unserializePHParray(content);
        System.out.println(reusltList);

    }



    @Test
    public void testphp(){
        HashMap<String,String> maps = new HashMap<>();
        maps.put("li","12");
        System.out.println(maps);
    }

    @Test
    public void testphpjson(){
        String s = "a:3:{s:12:\"参与人数\";s:5:\"23266\";s:6:\"姓名\";s:3:\"hhh\";s:6:\"手机\";s:11:\"13432333433\";}";
        CoachTool tool = new CoachTool();
        JSONObject jsonObject = tool.unserializePHPJsonObject(s);
        System.out.println(jsonObject);
    }





}
