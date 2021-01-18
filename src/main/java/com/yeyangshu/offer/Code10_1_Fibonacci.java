package com.yeyangshu.offer;

/**
 * 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author yeyangshu
 * @version 1.0
 * @date 2021/1/18 22:18
 */
public class Code10_1_Fibonacci {

    /**
     * 递归
     * 效率很低的解法，不推荐
     *
     * @param n
     * @return
     */
    public static int fibonacci1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * 实用解
     * 递归会有大量的重复计算，应该避免重复计算
     * 将已经得到的中间项保存起来，下次计算的时候先查找，避免重复计算
     *
     * @param n
     * @return
     */
    public static int fibonacci2(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        int fibMinOne = 1;
        int fibMinTwo = 0;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = fibMinOne + fibMinTwo;
            fibMinTwo = fibMinOne;
            fibMinOne = fib;
        }
        return fib;
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int fibonacci3(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        System.out.println(fibonacci1(45));
        System.out.println("fibonacci1：" + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        System.out.println(fibonacci2(45));
        System.out.println("fibonacci2：" + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        System.out.println(fibonacci3(45));
        System.out.println("fibonacci3：" + (System.currentTimeMillis() - start3));

        /**
         * 1134903170
         * fibonacci1：6914
         * 1134903170
         * fibonacci2：0
         * 1134903170
         * fibonacci3：0
         */
    }
}
