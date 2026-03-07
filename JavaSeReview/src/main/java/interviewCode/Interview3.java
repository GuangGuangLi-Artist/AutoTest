package interviewCode;

import java.util.ArrayList;

public class Interview3 {
    public static void main(String[] args) {
        /**
         * 左旋转字符串"abcdefg";
         */

        String s = "abcdefg";
        String xuanzhuaned = xuanzhuan(s);
        System.out.println(xuanzhuaned);

    }

    public static String xuanzhuan(String s1){
        String res = "";
        ArrayList<Character> list1 = new ArrayList<>();

        char[] chs = s1.toCharArray();
        //第一步，取出前两个字节a,b
        char first = chs[0];
        char second = chs[1];

        //第二步 取出后面的数据放到list
        for (int i = 2; i < chs.length; i++) {
            list1.add(chs[i]);
        }

        list1.add(first);
        list1.add(second);

        res = list1.toString();
        return res;
    }
}
