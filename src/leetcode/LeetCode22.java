package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * https://leetcode.cn/problems/generate-parentheses/
 */
public class LeetCode22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        process(list, "", n, n);
        return list;
    }

    public static void process(List<String> list, String s, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        } else {
            if (left == right) {
                process(list, s + "(", left - 1, right);
            } else if (left < right) {
                if (left > 0) {
                    process(list, s + "(", left - 1, right);
                }
                process(list, s + ")", left, right - 1);
            }
        }
    }

}
