package codesuixiang.stackDeeque;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 输入："abbaca"
 * 输出："ca"
 */
public class Lee_1047 {

    @Test
    public void testDeleDouble(){
        String ss = "abbaca";
        String string = deleDouble(ss);
        System.out.println(string);
        System.out.println("---------------");
        String byDeeque = deleByDeeque(ss);
        System.out.println(byDeeque);
    }


    public String deleDouble(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        //abbaca
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty() || chars[i] != stack.peek()) {// 如果栈为空或者栈顶和当前不一样 就入栈
                stack.push(chars[i]);
            }else {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        //String result = "";
        while (!stack.isEmpty()) {
            result = result.append(stack.pop());
        }
        return result.reverse().toString();

    }

    public String deleByDeeque(String s){
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(deque.isEmpty() || chars[i] != deque.peek()){
                deque.push(chars[i]);
            }else {
                deque.pop();
            }
        }
        String result = "";
        while (!deque.isEmpty()) {
            result = deque.pop() + result;
        }
        return result;
    }
}
