package stringOption;

import org.testng.annotations.Test;

/**
 * 剑指Offer58-II.左旋转字符串
 *     字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 *     该函数将返回左旋转两位得到的结果"cdefgab"。
 *     示例 2：
 *     输入: s = "lrloseumgh", k = 6
 *     输出: "umghlrlose"
 */
public class ReverseLeftWords {

    @Test
    public void testReverseLeftWords() {
        String s = "lrloseumgh";
        int k = 6;
        System.out.println(reverseLeftWords(s,k));

    }

    public String reverseLeftWords(String s, int k) {
        /**
         *  1 反转区间为前n的子串
         *  2 反转区间为n到末尾的子串
         *  3 反转整个字符串
         */

        int len = s.length();
        char[] chs = s.toCharArray();
        // 反转区间为前n的子串
        reverseXtoY(chs,0,k - 1);
        reverseXtoY(chs,k,len - 1);
        reverseXtoY(chs,0,len - 1);
        return new String(chs);
    }

    private void reverseXtoY(char[] chs, int left, int right) {
        while (left < right) {
            char temp = chs[right];
            chs[right] = chs[left];
            chs[left] = temp;
            left++;
            right--;
        }
    }
}
