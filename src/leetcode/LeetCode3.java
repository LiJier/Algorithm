package leetcode;

import java.util.HashMap;

public class LeetCode3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArr = s.toCharArray();
        int slow = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArr.length; i++) {
            char fastChar = charArr[i];
            if (map.containsKey(fastChar)) {
                slow = Math.max(slow, map.get(fastChar) + 1);
            }
            map.put(fastChar, i);
            maxLen = Math.max(maxLen, i - slow + 1);
        }
        return maxLen;
    }

}
