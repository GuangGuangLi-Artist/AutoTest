package codesuixiang.strOpe;

import org.testng.annotations.Test;

/**
 * 替换数字
 * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
 * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 * 对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"
 */
public class Ka_54 {

    @Test
    public void testReplaceNumner() {
        String ss = "a1b2c3";
        System.out.println(replaceNumner(ss));
    }

    public String replaceNumner(String s) {
        int count = 0;// 统计数字的个数
        int oldSize = s.length();
        for (int i = 0; i < oldSize; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                count++;
            }
        }

        // 扩充字符串s的大小，也就是每个空格替换成"number"之后的大小
        int newSize = oldSize + count * 5;
        char[] newsChar = new char[newSize];
        // 将旧字符串的内容填入新数组
        System.arraycopy(s.toCharArray(),0,newsChar,0,oldSize);


        // 从后先前将空格替换为"number"
        for (int i = newSize - 1, j = oldSize - 1; j < i; j--,i-- ) {
            if(!Character.isDigit(newsChar[j])){
                newsChar[i] = newsChar[j];
            }else {
                newsChar[i] = 'r';
                newsChar[i - 1] = 'e';
                newsChar[i - 2] = 'b';
                newsChar[i - 3] = 'm';
                newsChar[i -4] = 'u';
                newsChar[i -5] = 'n';
                i -= 5;
            }


        }
        return new String(newsChar);

    }
}
