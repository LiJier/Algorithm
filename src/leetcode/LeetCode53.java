package leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 子数组 是数组中的一个连续部分。
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class LeetCode53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { 5, 4, -1, 7, 8 }));
    }

    public static int maxSubArray(int[] nums) {
        int temp = nums[0];
        int max = temp;
        for (int i = 1; i < nums.length; i++) {
            if (temp + nums[i] >= nums[i]) {
                temp += nums[i];
            } else {
                temp = nums[i];
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
