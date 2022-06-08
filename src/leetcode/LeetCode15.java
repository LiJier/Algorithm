package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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
        int[] arr = Utils.getArray();
        long time1 = System.currentTimeMillis();
        List<List<Integer>> list = threeSum(arr);
        long time2 = System.currentTimeMillis();
        System.out.println("耗时：" + (time2 - time1));
        // Collections.sort(list, new Comparator<List<Integer>>() {

        // @Override
        // public int compare(List<Integer> arg0, List<Integer> arg1) {
        // return arg0.get(0).compareTo(arg1.get(0));
        // }

        // });
        // for (List<Integer> list2 : list) {
        // System.out.println(list2);
        // }
    }

    public static List<List<Integer>> threeSumBoom(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                for (int j2 = j + 1; j2 < nums.length; j2++) {
                    int num3 = nums[j2];
                    if (num1 + num2 + num3 == 0) {
                        List<Integer> three = new ArrayList<>();
                        three.add(num1);
                        three.add(num2);
                        three.add(num3);
                        Collections.sort(three);
                        set.add(three);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        if (nums.length == 3 && nums[0] + nums[1] + nums[2] == 0) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> three = new ArrayList<>();
            three.add(nums[0]);
            three.add(nums[1]);
            three.add(nums[2]);
            list.add(three);
            return list;
        }
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
        HashSet<List<Integer>> set = new HashSet<>();
        int zeroCount = R - 1 - L;
        if (zeroCount >= 3) {
            List<Integer> three = new ArrayList<>();
            three.add(0);
            three.add(0);
            three.add(0);
            set.add(three);
        }
        // 两负一正
        for (int i = 0; i <= L; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j <= L; j++) {
                int num2 = nums[j];
                for (int k = R; k < nums.length; k++) {
                    int num3 = nums[k];
                    if (num1 + num2 + num3 == 0) {
                        List<Integer> three = new ArrayList<>();
                        three.add(num1);
                        three.add(num2);
                        three.add(num3);
                        Collections.sort(three);
                        set.add(three);
                    }
                }
            }
        }
        // 两正一负
        for (int i = R; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                for (int k = 0; k <= L; k++) {
                    int num3 = nums[k];
                    if (num1 + num2 + num3 == 0) {
                        List<Integer> three = new ArrayList<>();
                        three.add(num3);
                        three.add(num2);
                        three.add(num1);
                        Collections.sort(three);
                        set.add(three);
                    }
                }
            }
        }
        if (zeroCount != 0) {
            // 一负一正
            for (int i = 0; i <= L; i++) {
                int num1 = nums[i];
                for (int k = R; k < nums.length; k++) {
                    int num2 = nums[k];
                    if (num1 + num2 == 0) {
                        List<Integer> three = new ArrayList<>();
                        three.add(num1);
                        three.add(0);
                        three.add(num2);
                        Collections.sort(three);
                        set.add(three);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

}
