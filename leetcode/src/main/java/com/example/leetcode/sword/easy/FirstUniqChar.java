package com.example.leetcode.sword.easy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i],!map.containsKey(arr[i]));
        }
        for(Map.Entry<Character,Boolean> entry : map.entrySet()) {
            if(entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
