package com.example.leetcode.sword.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 扑克牌中的顺子
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        int max = 0;
        int min = 14;
        for(int num: nums) {
            if(num == 0) continue;
            if(num>max) max = num;
            if(num<min) min = num;
            map.put(num,map.containsKey(num));
        }
        for(Map.Entry<Integer,Boolean> entry: map.entrySet()) {
            if(entry.getValue()) return false;
        }
        return max - min < 5;
    }
}
