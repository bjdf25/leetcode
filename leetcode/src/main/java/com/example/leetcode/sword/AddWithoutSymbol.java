package com.example.leetcode.sword;

/**
 * 不用加减乘除做加法
 */
public class AddWithoutSymbol {
    public int add(int a, int b) {
        if(b == 0) return a;
        // a + b = a^b + a&b << 1
        // a^b = 非进位和 a&b << 1 进位和
        return add(a^b,(a&b)<<1);
    }
    public int addByIterable(int a, int b) {
        while(b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
        // if(q.val < p.val) {
        //     TreeNode temp = p;
        //     p = q;
        //     q = temp;
        // }
        // while(root != null) {
        //     if(root.val < p.val) {
        //         root = root.right;
        //         continue;
        //     }
        //     if(root.val > q.val) {
        //         root = root.left;
        //         continue;
        //     }
        //     return root;
        // }
        // return root;
    }
}
