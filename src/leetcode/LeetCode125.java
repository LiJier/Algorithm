package leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * https://leetcode.cn/problems/valid-palindrome/
 */
public class LeetCode125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        char[] charArr = s.toCharArray();
        int L = 0;
        int R = charArr.length - 1;
        while (L <= R) {
            char cL = charArr[L];
            if (!Character.isLetterOrDigit(cL)) {
                L++;
                continue;
            }
            char cR = charArr[R];
            if (!Character.isLetterOrDigit(cR)) {
                R--;
                continue;
            }
            if (Character.toLowerCase(cL) != Character.toLowerCase(cR)) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }

}
