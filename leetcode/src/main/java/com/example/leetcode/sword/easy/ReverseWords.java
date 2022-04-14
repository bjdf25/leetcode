package com.example.leetcode.sword.easy;

/**
 *  I. 翻转单词顺序
 */
public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int j = i;
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--;
            // substring(),左闭右开：i+1为单词起始点，j+1为单词结束点
            sb.append(s.substring(i+1,j+1) + " ");
            while(i>=0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }
}
