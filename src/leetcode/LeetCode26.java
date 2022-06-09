package leetcode;

import java.util.Arrays;

/**
 * 给你一个升序排列的数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。元素的相对顺序应该保持一致
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class LeetCode26 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int N = nums.length;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (nums[index] != nums[i]) {
                index++;
                if (i != index) {
                    nums[index] = nums[i];
                }
            }
        }
        return index + 1;
    }

}
