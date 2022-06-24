package leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class LeetCode5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("1234567654321"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        char[] charArr = s.toCharArray();
        String palindrome = "";
        for (int i = 0; i < charArr.length; i++) {
            String s1 = findPalindrome(charArr, i, i);
            String s2 = findPalindrome(charArr, i, i + 1);
            if (s1.length() > palindrome.length()) {
                palindrome = s1;
            }
            if (s2.length() > palindrome.length()) {
                palindrome = s2;
            }
        }
        return palindrome;
    }

    public static String findPalindrome(char[] charArr, int L, int R) {
        while (L >= 0 && R < charArr.length && charArr[L] == charArr[R]) {
            L--;
            R++;
        }
        return String.valueOf(charArr, L + 1, R - L - 1);
    }

}
