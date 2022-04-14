package com.example.leetcode.sword.easy;

import com.example.leetcode.common.TreeNode;

/**
 * II. 平衡二叉树
 */
public class IsBalanced {
    // 根据深度判断，但是需要遍历整棵树，时间复杂度较高
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return Math.abs(dfs(root.left) - dfs(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
    // 后序遍历，剪枝
    public boolean isBalanced2(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs2(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        // 剪枝
        if (left == -1) return -1;
        int right = dfs(root.right);
        // 剪枝
        if(right == -1) return -1;
        // Math.max(left,right) + 1 计算树高
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }
}
