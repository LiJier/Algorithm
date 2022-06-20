package leetcode;

import java.util.HashMap;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class LeetCode70 {

    public static void main(String[] args) {
        System.out.println(climbStairs1(45));
        System.out.println(climbStairs3(45));
    }

    public static int climbStairs1(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return stairs(n, map);
    }

    public static int stairs(int n, HashMap<Integer, Integer> map) {
        if (n <= 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int num = stairs(n - 1, map) + stairs(n - 2, map);
            map.put(n, num);
            return num;
        }
    }

    public static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 1;
        int ans = a + b;
        for (int i = 2; i <= n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }
        return ans;
    }

}
