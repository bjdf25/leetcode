package com.example.leetcode.sword.easy;

import com.example.leetcode.common.TreeNode;

/**
 * 二叉搜索树的第k大节点
 * 利用二叉搜索树的特性，从右节点开始中序遍历，得到的即是递减序列数组
 */
public class kthLargest {
    int res;
    int k;
    public int KthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        // 剪枝
        if(k == 0) return;
        if(--k == 0) {
            res = root.val;
            return;
        }
        /**
         * 为什么不用if (--k == 0) { res = root.val;return;}?
         * 因为采用这种方式在return之后回溯的过程中，因为这个时候k已经等于0了，再次--k的话永不等于0，进入不到if代码块，就失去了剪枝的目的。
         * 为什么不用if (--k <= 0) { res = root.val;return;}?
         * 因为采用这种方式在return之后回溯的过程中，--k会小于0，进入if代码块之后就会改变res的值
         */
        dfs(root.left);
    }
}
