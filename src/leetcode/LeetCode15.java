package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithm.Utils;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0
 * 且不重复的三元组。
 * 
 * https://leetcode.cn/problems/3sum
 */
public class LeetCode15 {

    public static void main(String[] args) {
        int[] arr = new int[] { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int mValue = 0;
        int M = 0;
        int L = -1;
        int R = nums.length;
        while (M < R) {
            if (nums[M] < mValue) {
                Utils.swap(nums, L + 1, M);
                L++;
                M++;
            } else if (nums[M] > mValue) {
                Utils.swap(nums, R - 1, M);
                R--;
            } else {
                M++;
            }
        }
        if (L < 0 || R > nums.length - 1) {
            return new ArrayList<>();
        }
        if (L == 0 && R == nums.length - 1 && (nums[L] + nums[R] != 0)) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        int l = 0;
        int r = nums.length - 1;
        int m = L + 1;
        while (l <= L || r >= R) {
            int numL = nums[l];
            int numR = nums[r];
            int sumLR = numL + numR;
            if (sumLR > 0) {
                for (int i = l + 1; i < L; i++) {
                    int numM = nums[i];
                    if (sumLR + numM == 0) {
                        List<Integer> sumList = new ArrayList<>();
                        sumList.add(numL);
                        sumList.add(numM);
                        sumList.add(numR);
                        list.add(sumList);
                        break;
                    }
                }
                l++;
            } else if (sumLR < 0) {
                for (int i = r - 1; i > R; i--) {
                    int numM = nums[i];
                    if (sumLR + numM == 0) {
                        List<Integer> sumList = new ArrayList<>();
                        sumList.add(numL);
                        sumList.add(numM);
                        sumList.add(numR);
                        list.add(sumList);
                        break;
                    }
                }
                r--;
            } else {
                int numM = nums[m];
                if (numM == 0) {
                    List<Integer> sumList = new ArrayList<>();
                    sumList.add(numL);
                    sumList.add(numM);
                    sumList.add(numR);
                    list.add(sumList);
                }
                l++;
                r--;
            }
        }
        return list;
    }

}
