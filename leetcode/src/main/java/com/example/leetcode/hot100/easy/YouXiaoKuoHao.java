package com.example.leetcode.hot100.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 */
public class YouXiaoKuoHao {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>(){{
            put('(',')');
            put('[',']');
            put('{','}');
            put('?','?');
        }};
        if(!map.containsKey(s.charAt(0))) return false;
        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for(char c: s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(c);
            } else {
                if(map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }
}
