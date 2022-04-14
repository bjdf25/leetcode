package com.example.leetcode.sword.easy;

import com.example.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * I. 二叉树的深度
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    // 利用队列层序遍历
    public int maxDepthByIterable(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            res++;
            for(int i = que.size(); i > 0; i--) {
                TreeNode node = que.poll();
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
        }
        return res;
    }
}
