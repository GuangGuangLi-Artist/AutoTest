package leecodeAns.hot_100.easy;

import java.util.Locale;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 */
public class Ques_125 {

    public static void main(String[] args) {
        Ques_125 q = new Ques_125();
//        String sss = "A man, a plan, a canal: Panama";
        String sss = "race a car";
        boolean qPalindrome = q.isPalindrome(sss);
        System.out.println(qPalindrome);
    }

    public boolean isPalindrome(String s) {
        boolean flag = true;
        if(s == ""){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            //左指针跳过非字母数字字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            // 2. 右指针跳过非字母数字字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            //比较字符
            char leftc = Character.toLowerCase(s.charAt(left));
            char rightc = Character.toLowerCase(s.charAt(right));

            if(leftc != rightc) {
                return false;

            }
            left++;
            right--;


        }


        return flag;

    }
}
