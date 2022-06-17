package leetcode;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m
 * 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * https://leetcode.cn/problems/merge-sorted-array
 */
public class LeetCode88 {

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1 };
        int[] arr2 = new int[] {};
        merge(arr1, 1, arr2, 0);
        System.out.println(Arrays.toString(arr1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int M = m - 1;
        int N = n - 1;
        int index = m + n - 1;
        while (M >= 0 && N >= 0) {
            int num1 = nums1[M];
            int num2 = nums2[N];
            if (num1 > num2) {
                nums1[index--] = num1;
                M--;
            } else {
                nums1[index--] = num2;
                N--;
            }
        }
        while (M >= 0) {
            nums1[index--] = nums1[M--];
        }
        while (N >= 0) {
            nums1[index--] = nums2[N--];
        }
    }

}
