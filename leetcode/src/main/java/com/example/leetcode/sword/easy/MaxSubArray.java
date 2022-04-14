package com.example.leetcode.sword.easy;

/**
 * 连续子数组的最大和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] < 0 ? nums[i] : nums[i] + nums[i-1];
            // nums[i]也有可能是负数，还需要与目前最大数进行比较
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}
