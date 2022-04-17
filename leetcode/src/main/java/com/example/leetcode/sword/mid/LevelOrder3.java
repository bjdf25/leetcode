package com.example.leetcode.sword.mid;

import com.example.leetcode.common.TreeNode;

import java.util.*;

/**
 *  从上到下打印二叉树 III
 *  请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>(){{add(root);}};
        int sequence = 0;
        while(!que.isEmpty()) {
            // 之字形只需保证取节点的方式的不同，取完之后下一层的节点分布依然要保持原树形状
            List<Integer> list = new ArrayList<>();
            if((++sequence & 1) == 1) {
                for(int i = que.size(); i > 0; i--) {
                    TreeNode node = que.removeFirst();
                    list.add(node.val);
                    // 保证从左边取的节点的左右子节点也在左边
                    if(node.left != null) que.addLast(node.left);
                    if(node.right != null) que.addLast(node.right);
                }
            }else {
                for (int i = que.size(); i > 0; i--) {
                    TreeNode node = que.removeLast();
                    list.add(node.val);
                    // 保证从右边取的节点的左右子节点也在右边
                    if(node.right != null) que.addFirst(node.right);
                    if(node.left != null) que.addFirst(node.left);

                }
            }
            res.add(list);
        }
        return res;
    }
}
