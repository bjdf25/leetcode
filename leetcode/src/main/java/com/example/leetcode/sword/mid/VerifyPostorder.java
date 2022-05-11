package com.example.leetcode.sword.mid;

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    public boolean recur(int[] postorder, int left, int right) {
        if(left >= right) return true;
        int m = left;
        // 不能 while(postorder[m++] < postorder[right]); 这样写条件不满足时m依然会再++
        while(postorder[m] < postorder[right]) m++;
        int flag = m;
        while(postorder[m] > postorder[right]) m++;

        return m == right && recur(postorder, left, flag-1) && recur(postorder, flag, right -1);
    }
}
