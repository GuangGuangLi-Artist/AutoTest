package leecodeAns.base;

public class Ques_1422 {
    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));

    }

    public static int maxScore(String s) {
        char[] chars = s.toCharArray();
        int right1 = 0;
        for (char c : chars) {
            right1 += c - '0';
        }
        int ans = 0;
        int left0 = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '0') {
                left0++;
            } else {
                right1--;
            }
            ans = Math.max(ans, left0 + right1);
        }
        return ans;


    }
}
