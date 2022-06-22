package leetcode;

/*
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * https://leetcode.cn/problems/number-of-1-bits/
 */
public class LeetCode191 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(10));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

}