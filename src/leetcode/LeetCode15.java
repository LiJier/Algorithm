package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0
 * 且不重复的三元组。
 * 
 * https://leetcode.cn/problems/3sum
 */
public class LeetCode15 {

    public static void main(String[] args) {
        // int[] arr = Utils.getArray();
        int[] arr = new int[] { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
        System.out.println(threeSum2(arr));
        System.out.println(Arrays.toString(arr));
        // long time1 = System.currentTimeMillis();
        List<List<Integer>> list = threeSumBoom(arr);
        // long time2 = System.currentTimeMillis();
        // System.out.println("耗时：" + (time2 - time1));
        Collections.sort(list, new Comparator<List<Integer>>() {

            @Override
            public int compare(List<Integer> arg0, List<Integer> arg1) {
                return arg0.get(0).compareTo(arg1.get(0));
            }

        });
        System.out.println(list);
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
                swap(nums, L + 1, M);
                L++;
                M++;
            } else if (nums[M] > mValue) {
                swap(nums, R - 1, M);
                R--;
            } else {
                M++;
            }
        }
        fastSort(nums, 0, L);
        fastSort(nums, R, nums.length - 1);
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
        for (int L1 = 0; L1 < nums.length; L1++) {
            int L2 = L;
            int R1 = R;
            while (L2 > L1 && R1 < nums.length) {
                int num1 = nums[L1];
                int num2 = nums[L2];
                int num3 = nums[R1];
                if (num1 + num2 + num3 == 0) {
                    List<Integer> three = new ArrayList<>();
                    three.add(num1);
                    three.add(num2);
                    three.add(num3);
                    set.add(three);
                    L2--;
                    R1++;
                } else if (num1 + num2 + num3 < 0) {
                    R1++;
                } else {
                    L2--;
                }
            }
        }
        // 两正一负
        for (int R1 = R; R1 < nums.length; R1++) {
            int L1 = 0;
            int R2 = nums.length - 1;
            while (L1 <= L && R2 > R1) {
                int num1 = nums[L1];
                int num2 = nums[R1];
                int num3 = nums[R2];
                if (num1 + num2 + num3 == 0) {
                    List<Integer> three = new ArrayList<>();
                    three.add(num1);
                    three.add(num2);
                    three.add(num3);
                    set.add(three);
                    L1++;
                    R2--;
                } else if (num1 + num2 + num3 > 0) {
                    R2--;
                } else {
                    L1++;
                }
            }
        }
        if (zeroCount != 0) {
            int L4 = 0;
            int R4 = nums.length - 1;
            while (L4 <= L && R <= R4) {
                int num1 = nums[L4];
                int num2 = nums[R4];
                if (num1 + num2 == 0) {
                    List<Integer> three = new ArrayList<>();
                    three.add(num1);
                    three.add(num2);
                    three.add(0);
                    set.add(three);
                    L4++;
                    R4--;
                } else if (num1 + num2 > 0) {
                    R4--;
                } else {
                    L4++;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void fastSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) Math.random() * (R - L + 1), R);
            int[] p = partition(arr, L, R);
            fastSort(arr, L, p[0] - 1);
            fastSort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int l = L - 1;
        int r = R;
        while (L < r) {
            if (arr[L] < arr[R]) {
                swap(arr, ++l, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --r, L);
            } else {
                L++;
            }
        }
        swap(arr, r, R);
        return new int[] { l + 1, r };
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        if (nums.length == 3 && nums[0] + nums[1] + nums[2] == 0) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> three = new ArrayList<>(3);
            three.add(nums[0]);
            three.add(nums[1]);
            three.add(nums[2]);
            list.add(three);
            return list;
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return list;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int num1 = nums[i];
                int num2 = nums[L];
                int num3 = nums[R];
                int sum = num1 + num2 + num3;
                if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    List<Integer> three = new ArrayList<>(3);
                    three.add(num1);
                    three.add(num2);
                    three.add(num3);
                    list.add(three);
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    R--;
                    L++;
                }
            }
        }
        return list;
    }

}
