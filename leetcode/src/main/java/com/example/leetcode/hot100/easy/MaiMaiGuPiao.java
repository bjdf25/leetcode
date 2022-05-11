package com.example.leetcode.hot100.easy;

/**
 * 买卖股票的最佳时机
 */
public class MaiMaiGuPiao {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit,prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
