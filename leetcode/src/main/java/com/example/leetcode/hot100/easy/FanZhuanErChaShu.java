package com.example.leetcode.hot100.easy;

import com.example.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 */
public class FanZhuanErChaShu {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        root.left = r;
        root.right = l;
        return root;
    }

    public TreeNode invertTreeByQue(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            TreeNode node = que.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) que.add(node.left);
            if(node.right != null) que.add(node.right);
        }
        return root;
    }
}
