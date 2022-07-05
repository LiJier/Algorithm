package leetcode.offer;

public class LeetCode10 {

    public static void main(String[] args) {
        System.out.println(fib2(48));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = b + a;
        for (int i = 2; i <= n; i++) {
            sum = (b + a) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        return (fib2(n - 1) + fib2(n - 2)) % 1000000007;
    }

}