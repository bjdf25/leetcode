package com.example.leetcode.sword.mid;

/**
 * I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CuttingRope {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        // dp[i]表示长度为i的绳子剪成m段所得到的最大乘积
        // dp[1]不存在，因为长度n>1
        // dp[2] = 1，因为必须剪成两段， 1*1
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            // 要求长度为i的绳子剪成m段所得到的最大乘积，得求该绳子的第一段绳长从长度为1到i-2开始遍历找到最大的dp[i]
            // 为什么第一段绳长只能是1到i-2而不是i-1?因为如果第一段绳长j来到i-1的时候，dp[i] = Max(j*(i-j),j*dp[i-j])的情况下，dp[i-j] = dp[1]是不成立的
            for (int j = 1; j < i - 1; j++) {
                // i表示长度为i的绳子，j表示长度为i的绳子要剪的第一段绳长
                // dp[i]要么等于第一段绳长为j，后面的绳子只剪一段，第二段为i-j
                // 要么一段绳长为j，后面的绳子剪多段，剪多段的最大绳长为dp[i-1]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
