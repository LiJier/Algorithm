package leetcode;

import java.util.Stack;

import javax.lang.model.element.Element;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * https://leetcode.cn/problems/valid-parentheses
 */
public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(isValid("(])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
