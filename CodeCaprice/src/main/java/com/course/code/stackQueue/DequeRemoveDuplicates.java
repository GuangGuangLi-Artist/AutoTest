package com.course.code.stackQueue;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1047 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 *     输入："abbaca"
 *     输出："ca"
 *     解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class DequeRemoveDuplicates {

    public static void main(String[] args) {
        String s = "abbaca";

        String res = dequeRemoveDuplicates(s);
        System.out.println(res);

        String ss = "abbaca";
        String res_1 = removeDuplicates(ss);
        System.out.println(res_1);
    }

    public static String dequeRemoveDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if(deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            }else {
                deque.pop();//从这个deque表示的堆栈中弹出一个元素。 换句话说，删除并返回此deque的第一个元素。
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素 //deque = [a,c]
        while (!deque.isEmpty()) {
            str = deque.pop() + str;  //先弹出a str = a 再弹出c a放在str前面 str = ca
        }
        return str;
    }

    @Test
    public void testStr() {
        String s = "";
        int i = 0;
        while (i<3) {
            s = i + s;
            i++;
        }
        System.out.println(s);
    }

    public static String removeDuplicates(String s) {
        //双指针法
        char[] chs = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while (fast < chs.length) {
            //直接用fast指针覆盖slow指针的值
            chs[slow] = chs[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if(slow > 0 && chs[slow] == chs[slow - 1]) {
                slow--;
            }else {
                slow ++;
            }
            fast++;
        }
        return new String(chs,0,slow);
    }
}
