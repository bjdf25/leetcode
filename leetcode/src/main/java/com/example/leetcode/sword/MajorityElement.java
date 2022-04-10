package com.example.leetcode.sword;

/**
 * 数组中出现次数超过一半的数字
 */
public class MajorityElement {
    // 方法一：摩尔计数法 原理：重重抵消后剩下得的票就为票主，因为次数超过一半的数字总会大于其他数的次数总和，所以抵销不完
    public int majorityElement(int[] nums) {
        int x = 0;
        int vote = 0;
        for(int num: nums) {
            // 没有票主时设置当前数为票主
            if(vote == 0) x = num;
            // 支持票主加1，不支持抵消-1
            vote += x == num ? 1 : -1;
        }
        return x;
    }
    // 方法二：哈希表
    // 方法三：排序后取中位数
}
