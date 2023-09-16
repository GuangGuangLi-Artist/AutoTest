package stringOption;


import org.testng.annotations.Test;

/**
 * 151 翻转字符串里的单词
 *     给定一个字符串，逐个翻转字符串中的每个单词。
 *     示例 1：
 *     输入: "the sky is blue"
 *     输出: "blue is sky the"
 *
 *     示例 2：
 *     输入: "  hello world!  "
 *     输出: "world! hello"
 *     解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 *     示例 3：
 *     输入: "a good   example"
 *     输出: "example good a"
 *     解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {


    @Test
    public void testReverseWordsByLow() {
        System.out.println(reverseWordsByLow("the sky is blue"));
        System.out.println(reverseWordsByLow("a good   example"));
        System.out.println(reverseWordsByLow("  hello world!  "));
    }

    @Test
    public void testReverseWords() {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("  hello world!  "));
    }



    //low方法 1 去除前后空格 2 按照空格切成字符数组 反转每个单词 3 拼接成新的字符串
    public String reverseWordsByLow(String s) {
        //正则表达式 + 至少1个字符; * 任意个数字符; A{2,} 至少n个字符
        String[] sArr = s.trim().split(" {1,}"); // + 也行
        StringBuilder sb = new StringBuilder();
        for (int i = sArr.length - 1; i >= 0 ; i--) {
            if(i == 0) {
                sb.append(sArr[i]);
            }else {
                sb.append(sArr[i]).append(" ");
            }
        }

        return new String(sb);
    }

    /**
     * 分三步走
     * 1 去除空格
     * 2 反转整个字符串
     * 3 反转单词
     */

    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        // 用 快慢指针 去除首尾以及中间多余空格，可参考数组元素移除的题解
        chs  = removeSpaceBa(chs);

        //双指针实现指定范围内字符串反转，可参考字符串反转题解
        reverseString(chs,0,chs.length - 1);

        //3.单词反转
        reverseEachWord(chs);

        return new String(chs);
    }




    private char[] removeSpaceBa(char[] chs) {
        int slow = 0;
        for (int fast = 0; fast < chs.length; fast++) {
            //先用 fast 移除所有空格
            if(chs[fast] != ' ') { //是空格就继续向后走


                //再用 slow 加空格。 单词末尾要加空格
                if(slow != 0) {
                    chs[slow++] = ' ';
                }
                //fast 遇到空格或遍历到字符串末尾，就证明遍历完一个单词了
                while (fast < chs.length && chs[fast] != ' ') {
                    chs[slow++] = chs[fast++];
                }
            }
        }
        char [] newChar = new char[slow];
        System.arraycopy(chs,0,newChar,0,slow);
        return newChar;
    }

    //双指针实现指定范围内字符串反转，可参考字符串反转题解
    private void reverseString(char[] chs, int left, int right) {
        if(right >= chs.length) {
            return;
        }

        while (left < right) {
            /**
             * 替换详解
             *    char temp = chs[right] 啥都没干  临时变量存起来来后边的值chs[right]
             *    chs[right] = chs[left] 将chs[right]的值直接被chs[left]的值覆盖了 此刻 chs[left] 的值还是没变
             *    chs[left] = temp 将保存提出来的chs[right]的值直接覆盖chs[left]
             */
            char temp = chs[right];
            chs[right] = chs[left];
            chs[left] = temp;
            left++;
            right--;
        }

    }

    // 单词反转
    private void reverseEachWord(char[] chs) {
        int start = 0;
        for (int end = 0; end <= chs.length; end++) {
            if(end == chs.length || chs[end] == ' ') {//如果不是碰到末尾和空格 就直接向后走
                reverseString(chs,start,end - 1);
                start = end + 1;
            }
        }
    }


}
