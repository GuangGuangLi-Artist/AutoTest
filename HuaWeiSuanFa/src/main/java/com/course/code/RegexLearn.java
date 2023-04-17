package com.course.code;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLearn {

    @Test
    public void testRegex(){

        //String rex = "(\\[img\\])*";
        String rex = "\\d{7}";
        String oldContent = "[img::::9859025:::|style=&quot;&quot;:::][img::::9859027:::|style=&quot;&quot;:::]" +
                "[img::::9859029:::|style=&quot;&quot;:::]" +
                "[img::::9859031:::|style=&quot;&quot;:::][img::::9859033:::|style=&quot;&quot;:::]";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(oldContent);
        String newfir = "";
        while (matcher.find()){
            newfir = matcher.group();
            System.out.println(newfir);

        }



    }
}
