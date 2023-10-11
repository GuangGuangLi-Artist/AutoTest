package com.course.code.stackQueue;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *     注意空字符串可被认为是有效字符串。
 *     示例 1:
 *
 *     输入: "()"
 *     输出: true
 *
 *     示例 2:
 *
 *     输入: "()[]{}"
 *     输出: true
 *
 *     示例 3:
 *
 *     输入: "(]"
 *     输出: false
 *
 *     示例 4:
 *
 *     输入: "([)]"
 *     输出: false
 *
 *     示例 5:
 *
 *     输入: "{[]}"
 */
public class DequeIsValid {

    /**
     * 第一种情况，字符串里左方向的括号多余了 ，所以不匹配。
     * 第二种情况，括号没有多余，但是 括号的类型没有匹配上。 括号匹配2
     * 第三种情况，字符串里右方向的括号多余了，所以不匹配。
     *
     * 第一种情况：已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false
     * 第二种情况：遍历字符串匹配的过程中，发现栈里没有要匹配的字符。所以return false
     * 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号return false
     *
     *
     */

    public static void main(String[] args) {
        String s = "([{}]()";
        System.out.println(isValid(s));
    }

    public static  boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号 就把响应的右括号入栈
            if(ch == '(') {
                deque.push(')');
            }else if (ch == '[') {
                deque.push(']');
            }else if(ch == '{') {
                deque.push('}');
            }else if(deque.isEmpty() || deque.peek() != ch) { //peek() 查看队列中的第一个元素
                // 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号 return false
                // 第二种情况：遍历字符串匹配的过程中，发现栈里没有我们要匹配的字符。所以return false
                return false;
            }else {
                deque.pop(); //弹出第一个元素
            }
        }
        // 第一种情况：此时我们已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false，否则就return true
        return deque.isEmpty();
    }

}
