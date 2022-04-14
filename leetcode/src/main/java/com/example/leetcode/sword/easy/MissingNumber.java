package com.example.leetcode.sword.easy;

/**
 *  II. 0～n-1中缺失的数字
 */
public class MissingNumber {
    // 找出nums[m] != m 的左边界即为消失的数字
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
