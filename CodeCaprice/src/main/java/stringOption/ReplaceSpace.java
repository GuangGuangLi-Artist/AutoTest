package stringOption;


import org.testng.annotations.Test;

/**
 * 剑指offer05 替换空格
 *     请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *     示例 1： 输入：s = "We are happy."
 *     输出："We%20are%20happy."
 */
public class ReplaceSpace {

    @Test
    public void testReplaceSpace() {
        String ss = "We are happy.";
        System.out.println(replaceSpaceFunc(ss));

    }

    @Test
    public void testReplaceSpaceByTwoPointer() {
        String ss = "We are happy.";
        System.out.println(replaceSpaceByTwoPointer(ss));

    }



    //low方法
    public String replaceSpaceFunc(String s) {
        return s.replace(" ", "%20");
    }

    //双指针替换法
    public String replaceSpaceByTwoPointer(String s) {
        if (s.length() == 0 || s == null) return s;

        //扩充字符数组 遇到空格就替换为2倍
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        if (sb.length() == 0) return s;

        int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
        s += sb.toString();
        char[] chs = s.toCharArray();
        int right = chs.length - 1;//右指针：指向扩展字符串的最后一个位置


        while (left > 0) {
            if (chs[left] == ' ') {
                chs[right--] = '0';
                chs[right--] = '2';
                chs[right] = '%';
            } else {
                chs[right] = chs[left];
            }

            right--;
            left--;

        }

        return new String(chs);

    }


}
