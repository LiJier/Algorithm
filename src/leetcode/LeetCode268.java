package leetcode;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 
 * https://leetcode.cn/problems/missing-number/
 */
public class LeetCode268 {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    }

    public static int missingNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

}
