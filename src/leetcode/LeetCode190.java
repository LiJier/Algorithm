package leetcode;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 
 * https://leetcode.cn/problems/reverse-bits/
 */
public class LeetCode190 {

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int[] arr = new int[32];
        for (int i = 0; i < 32; i++) {
            arr[i] = (n & (1 << i)) == 0 ? 0 : 1;
        }
        int num = 0;
        int temp = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            num += arr[i] * temp;
            temp *= 2;
        }
        return num;
    }

}
