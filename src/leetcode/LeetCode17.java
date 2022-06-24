package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class LeetCode17 {

    public static void main(String[] args) {
        letterCombinations("234");
    }

    public static List<String> letterCombinations(String digits) {
        char[] charArr = digits.toCharArray();
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
        List<List<Character>> digitsList = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            List<Character> list = map.get(c);
            digitsList.add(list);

        }
        return null;
    }

}
