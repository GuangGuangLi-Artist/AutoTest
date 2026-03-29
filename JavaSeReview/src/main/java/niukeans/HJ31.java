package niukeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 对于给定的若干个单词组成的句子，每个单词均由大小写字母构成，单词间使用非字母字符分隔。输出以单词为单位逆序排放的结果，即仅逆序单词间的相对顺序，不改变单词内部的字母顺序。
 * 特别地，在输出结果中，去除原有的分隔符，转而使用单个空格间隔单词。
 * 输入：$bo*y gi!r#l
 * 输出：l r gi y bo
 *
 */

public class HJ31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            //$bo*y gi!r#l
            String resource = in.nextLine();
            char [] chs = resource.toCharArray();

            List<String> list = new ArrayList<>();
            StringBuilder curreentWord = new StringBuilder();

            for(char ch:chs){
                if(Character.isLetter((ch))){
                    curreentWord.append(ch);
                }else{
                    if(curreentWord.length() > 0) {//遍历字符串，遇到字母就累积，遇到非字母就结算当前单词（如果有）
                        list.add(curreentWord.toString());
                        curreentWord.setLength(0);//清空
                    }
                }


            }

            if(curreentWord.length() > 0){//处理最后一个单词（如果有的话）
                list.add(curreentWord.toString());
            }

            //逆序
            Collections.reverse(list);

            System.out.println(String.join(" ",list));
        }
    }
}
