package leetcode;

/***
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 
 * 
 * 时间复杂度暂未达到
 ***/
public class LeetCode4 {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 3, 5, 7, 9 };
        int[] nums2 = new int[] { 2, 4, 6, 8 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] newArr = new int[nums1.length + nums2.length];
        for (int k = 0; k < newArr.length; k++) {
            if (i < nums1.length && j < nums2.length) {
                int num1 = nums1[i];
                int num2 = nums2[j];
                if (num1 < num2) {
                    newArr[k] = num1;
                    i++;
                } else {
                    newArr[k] = num2;
                    j++;
                }
            } else if (i < nums1.length && j >= nums2.length) {
                newArr[k] = nums1[i];
                i++;
            } else if (i >= nums1.length && j < nums2.length) {
                newArr[k] = nums2[j];
                j++;
            }
        }
        return (newArr.length % 2 == 0) ? (newArr[newArr.length / 2 - 1] + newArr[newArr.length / 2]) / 2.0
                : newArr[newArr.length / 2];
    }

}
