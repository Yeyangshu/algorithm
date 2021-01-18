package com.yeyangshu.offer;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2021/1/18 23:26
 */
public class Code10_2_NumWays {
    public static int numWays(int n) {
        int[] result = {0, 1, 2};
        if (n <= 2) {
            return result[n];
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(3));
    }
}
