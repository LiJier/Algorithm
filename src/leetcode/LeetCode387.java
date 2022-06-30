package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 
 * https://leetcode.cn/problems/first-unique-character-in-a-string/
 */
public class LeetCode387 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        char[] charArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (map.containsKey(c)) {
                list.remove(map.get(c));
            } else {
                list.add(i);
            }
            map.put(c, i);
        }
        return list.isEmpty() ? -1 : list.getFirst();
    }

}
