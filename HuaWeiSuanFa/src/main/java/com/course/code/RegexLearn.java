package com.course.code;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLearn {

    @Test
    public void test(){

        //String rex = "(\\[img\\])*";
        String rex = "(\\[img\\D{4}\\d{6,8}\\D*\\])*";
        String oldContent = "[img::::9859025:::|style=&quot;&quot;:::][img::::9859027:::|style=&quot;&quot;:::]" +
                "[img::::9859029:::|style=&quot;&quot;:::]" +
                "[img::::9859031:::|style=&quot;&quot;:::][img::::9859033:::|style=&quot;&quot;:::]";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(oldContent);
        String newfir = "";
        if(matcher.matches()){
            newfir = matcher.group(0);

        }else {
            System.out.println("匹配不到");
        }
        //String newRex = "((\\[img\\D{4})(\\d{7})(\\D*\\]))*";
        //String newRex = "\\[(.*?)]";
        String newRex = "\\[img\\:\\:\\:\\:(\\d{7})\\:\\:\\:\\|style\\=\\&quot\\;\\&quot\\;\\:\\:\\:\\]";
        Pattern pattern1 = Pattern.compile(newRex);
        Matcher matcher1 = pattern1.matcher(newfir);
        if(matcher1.matches()){
            System.out.println(matcher1.group(0));
        }else {
            System.out.println("匹配失败");
        }

        //System.out.println(matcher.groupCount());

    }
}
