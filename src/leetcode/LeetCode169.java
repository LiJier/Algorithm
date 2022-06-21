package leetcode;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 
 * https://leetcode.cn/problems/majority-element/
 */
public class LeetCode169 {

    public static int majorityElement(int[] nums) {
        int a = nums[0];
        int b = 1;
        for (int i = 0; i < nums.length; i++) {
            if (a == nums[i]) {
                b++;
            } else {
                b--;
                if (b == 0) {
                    a = nums[i];
                    b = 1;
                }
            }
        }
        return a;
    }

}
