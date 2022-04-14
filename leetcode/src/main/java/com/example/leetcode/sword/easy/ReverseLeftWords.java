package com.example.leetcode.sword.easy;

/**
 * II. 左旋转字符串
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = n; i < s.length() + n; i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }
}
