package com.example.leetcode.sword.easy;

import com.example.leetcode.common.TreeNode;

/**
 * II. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root;
        TreeNode l = lowestCommonAncestor(root.left, p ,q);
        TreeNode r = lowestCommonAncestor(root.right, p ,q);
        // if (l == null && r == null） return null;
        if (l == null) return r;
        if (r == null) return l;
        return root;
    }
}
