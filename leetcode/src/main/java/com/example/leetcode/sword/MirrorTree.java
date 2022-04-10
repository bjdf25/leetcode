package com.example.leetcode.sword;

import com.example.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 镜像二叉树
 */
public class MirrorTree {
    public TreeNode stack(TreeNode root) {
        // stack加入了null之后不为空，所以要对root进行判空
         if(root == null) return null;
         Stack<TreeNode> stack = new Stack<>();
         stack.add(root);
         while (!stack.isEmpty()) {
             TreeNode node = stack.pop();
             if(node.right != null) stack.push(node.right);
             if(node.left != null) stack.push(node.left);
             TreeNode temp = node.left;
             node.left = node.right;
             node.right = temp;
         }
         return root;
    }

    public TreeNode queue(TreeNode root) {
        // 队列加入null之后isEmpty方法返回false
        if(root == null) return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            for(int i = que.size(); i > 0; i--) {
                TreeNode node = que.poll();
                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }

    public TreeNode recur(TreeNode root) {
        if(root == null) return root;
        TreeNode l = recur(root.left);
        TreeNode r = recur(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
