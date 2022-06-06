package leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * https://leetcode.cn/problems/reverse-integer
 */
public class LeetCode7 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469) + "");
    }

    public static int reverse(int x) {
        int temp = x;
        long n = 0;
        while (temp != 0) {
            n = n * 10 + temp % 10;
            temp = temp / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

}
