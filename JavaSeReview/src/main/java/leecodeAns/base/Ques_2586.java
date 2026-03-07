package leecodeAns.base;

public class Ques_2586 {

    private static final String VOWEL = "aoeiu";

    public static void main(String[] args) {
        String[] words = {"are","amy","u"};
        //System.out.println(vowelStrings(words,0,2));
        String s = "amy";
        System.out.println(VOWEL.indexOf(s.charAt(2)));


    }


    public static int vowelStrings(String[] words, int left, int right) {

        int ans = 0;
        for(int i = left;i <= right; i++) {
            String s = words[i];
            if(VOWEL.indexOf(s.charAt(0)) != -1 && VOWEL.indexOf(s.charAt(s.length()-1)) != -1){//字符串中不存在字母 就会返回-1
                ans++;
            }

        }
        return ans;

    }
}
