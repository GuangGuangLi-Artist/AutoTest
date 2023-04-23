package com.course.code;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * 字符串加密
 *
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，将所得结果作为新字母表开头，并将新建立的字母表中未出现的字母按照正常字母表顺序加入新字母表。如下所示：
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y (实际需建立小写字母的字母表，此字母表仅为方便演示）
 *
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙， Attack AT DAWN (黎明时攻击)就会被加密为Tpptad TP ITVH。
 *
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 *
 * a b c d e f g h i j k l m n o p q r s t u v w x y z
 * n i h a o b c d e f g j k l m p q r s t u v w x y z
 */
public class HuaWeiHJ36 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String key = sc.nextLine();
            String msg = sc.nextLine();

            //将key添加到set中
            Set<Character> setKey = new LinkedHashSet<>();
            for (int i = 0; i < key.length(); i++) {
                setKey.add(key.charAt(i));
            }

            //补齐剩余字母 因为LinkedHashSet有序 所以是顺序不变
            char c = 'a';
            while (setKey.size()<26){
                setKey.add(c++);
            }

            StringBuffer stringBuffer = new StringBuffer();
            char[] charArr = msg.toCharArray();
            ArrayList<Character> arrayList = new ArrayList<>(setKey);

            for (int i = 0; i < msg.length(); i++) {
                if(msg.charAt(i) >= 'A' && msg.charAt(i) <= 'Z'){
                    int tmp = charArr[i] - 'A';
                    stringBuffer.append(String.valueOf(arrayList.get(tmp)).toUpperCase());
                }else {
                    int tmp = charArr[i] - 'a';
                    stringBuffer.append(String.valueOf(arrayList.get(tmp)).toLowerCase());
                }
            }

            System.out.println(stringBuffer.toString());
        }

    }
}
