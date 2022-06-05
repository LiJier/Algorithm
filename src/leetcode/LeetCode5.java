package leetcode;

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
            String s1 = findPalindrome(s, i, i);
            String s2 = findPalindrome(s, i, i + 1);
            if (s1.length() > palindrome.length()) {
                palindrome = s1;
            }
            if (s2.length() > palindrome.length()) {
                palindrome = s2;
            }
        }
        return palindrome;
    }

    public static String findPalindrome(String s, int L, int R) {
        char[] charArr = s.toCharArray();
        while (L >= 0 && R < charArr.length && charArr[L] == charArr[R]) {
            L--;
            R++;
        }
        return s.substring(L + 1, R);
    }
}
