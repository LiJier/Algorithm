package leetcode;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * https://leetcode.cn/problems/plus-one
 */
public class LeetCode66 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(
                new int[] { 9, 9, 9 })));
    }

    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        } else {
            int temp = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int num = digits[i];
                digits[i] = (num + temp) >= 10 ? 0 : num + temp;
                temp = (num + temp) / 10;
            }
            if (temp != 0) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = temp;
                return newDigits;
            } else {
                return digits;
            }
        }
    }

}
