package com.example.leetcode.sword.mid;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  I. 从上到下打印二叉树
 *  从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            TreeNode node = que.poll();
            if(node.left != null) que.add(node.left);
            if(node.right != null) que.add(node.right);
            list.add(node.val);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
