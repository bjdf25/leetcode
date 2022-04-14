package com.example.leetcode.sword.easy;

import java.util.Stack;

/**
 * 最小函数栈
 */
public class MinStack {
    Stack<Integer> master;
    Stack<Integer> slave;
    /** initialize your data structure here. */
    public MinStack() {
        master = new Stack<>();
        slave = new Stack<>();
    }

    public void push(int x) {
        master.push(x);
        if( slave.isEmpty() || slave.peek() >=x ) {
            slave.push(x);
        }
    }

    public void pop() {
        if(master.pop() == slave.peek()) {
            slave.pop();
        }
    }

    public int top() {
        return master.peek();
    }

    public int min() {
        return slave.peek();
    }
}
