package leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 
 * https://leetcode.cn/problems/divide-two-integers
 */
public class LeetCode29 {

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        }
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int ans = 0;
        while (dividend <= divisor) {
            int tmp = divisor, count = 1;
            while (tmp >= dividend - tmp) {
                tmp += tmp;
                count += count;
            }
            dividend -= tmp;
            ans += count;
        }
        return sign < 0 ? -ans : ans;
    }

}
