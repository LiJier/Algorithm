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
        System.out.println(climbStairs(45));
    }

    public static int climbStairs(int n) {
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

}
