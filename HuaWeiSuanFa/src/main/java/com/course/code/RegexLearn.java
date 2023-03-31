package com.course.code;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLearn {

    @Test
    public void test(){

        //String rex = "(\\[img\\])*";
        String rex = "(\\[img\\D{4}\\d{6,8}\\D*\\])*";
        String oldContent = "[img::::9859025:::|style=&quot;&quot;:::][img::::9859027:::|style=&quot;&quot;:::]";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(oldContent);
        if(matcher.matches()){
            String con = matcher.group(0);
            String con1 = matcher.group(1);
            System.out.println(con);
            System.out.println(con1);
        }else {
            System.out.println("匹配不到");
        }
    }
}
