package com.example.leetcode.sword;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树Ⅱ
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        // bfs优先使用队列
        while(!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i = que.size(); i > 0; i--) {
                TreeNode node = que.poll();
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}
