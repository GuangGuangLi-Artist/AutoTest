package codesuixiang.stackDeeque;

import org.testng.annotations.Test;

import java.util.Stack;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *  左括号必须用相同类型的右括号闭合。
 *  左括号必须以正确的顺序闭合。
 *  注意空字符串可被认为是有效字符串。
 *  输入: "()"
 *  输出: true
 *
 */
public class Lee_20 {

    @Test
    public void testIsv(){
        String s = "()[]{}";
        boolean isv = isVailble(s);
        System.out.println(isv);
    }

    public boolean isVailble(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        if(s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ')' && !stack.isEmpty() && stack.peek() == '(') { // 当前为')' 且栈不为空 且栈顶是'(' 就弹出'('
                stack.pop();
            } else if (chars[i] == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();

            }else if (chars[i] == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }else {
                stack.push(chars[i]);//入栈
            }
        }

        //遍历结束，如果栈为空，则括号全部匹配
        return stack.isEmpty();
    }
}
