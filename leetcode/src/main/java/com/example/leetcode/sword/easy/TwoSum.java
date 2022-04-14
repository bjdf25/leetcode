package com.example.leetcode.sword.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为s的两个数字
 */
public class TwoSum {
    // 空间 O(n), 时间 O(n)
    public int[] twoSum(int[] nums, int target) {
         Map<Integer,Integer> map = new HashMap<>();
         for(int num: nums) {
             if(map.containsKey(num)) {
                 return new int[]{num,map.get(num)};
             }else {
                 map.put(target - num, num);
             }
         }
         return new int[0];

    }
    // 空间 O(1), 时间O(N)
    public int[] twoSumDoublePtr(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            if((nums[i]+nums[j]) > target) {
                j--;
            } else if ((nums[i]+nums[j]) < target) {
                i++;
            }else {
                return new int[]{nums[i],nums[j]};
            }
        }
        return new int[0];
    }

}
