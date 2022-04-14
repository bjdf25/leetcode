package com.example.leetcode.sword.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * II. 和为s的连续正数序列
 * 可以利用递增序列数组来解决问题
 * 双指针滑动窗口
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1;
        int j = 2;
        int s = 3;
        while(i < j) {
            if(s == target) {
                int[] arr = new int[j-i+1];
                for(int k = i; k <= j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
            }
            // 大于target左窗口收缩，等于target左窗口也要收缩
            if(s >= target) {
                s -= i;
                i++;
            } else {
                // 小于target右窗口拓展
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
