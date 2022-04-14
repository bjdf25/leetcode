package com.example.leetcode.sword.easy;

import com.example.leetcode.common.TreeNode;

/**
 * 对称二叉树
 */
public class IsSymmetric {
    public boolean IsSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        // 走到此步说明左右节点为对称节点，继续遍历左右节点的子节点
        return recur(left.left,right.right) && recur(left.right, right.left);
    }
}
