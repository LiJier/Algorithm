package leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 
 * https://leetcode.cn/problems/move-zeroes/
 */
public class LeetCode283 {

    public static void main(String[] args) {
        int[] nums = new int[] { 0,1,0,0,12 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int lastNotZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, ++lastNotZero, i);
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
