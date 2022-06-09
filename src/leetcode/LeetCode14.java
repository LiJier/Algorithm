package leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * https://leetcode.cn/problems/longest-common-prefix/
 */
public class LeetCode14 {

    public static void main(String[] args) {
        String[] strs = { "dog", "dogracecar", "dogcar" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        for (int index = 0; index < Integer.MAX_VALUE; index++) {
            char lastChar = ' ';
            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    return strs[i];
                }
                if (i == 0) {
                    lastChar = strs[i].charAt(index);
                } else {
                    char cur = strs[i].charAt(index);
                    if (cur != lastChar) {
                        return strs[i].substring(0, index);
                    }
                }
            }
        }
        return "";
    }

}
