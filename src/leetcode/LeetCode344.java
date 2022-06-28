package leetcode;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 
 * https://leetcode.cn/problems/reverse-string
 */
public class LeetCode344 {

    public static void main(String[] args) {

    }

    public static void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int L = 0;
        int R = s.length - 1;
        while (L < R) {
            swap(s, L, R);
            L++;
            R--;
        }

    }

    public static void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}