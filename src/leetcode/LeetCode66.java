package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
