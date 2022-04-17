package com.example.leetcode.sword.mid;

import com.example.leetcode.common.TreeNode;

import java.util.HashMap;

/**
 * 重建二叉树
 */
public class RebuildTree {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * 该方法只适用于没有重复节点值的树，因为该方法中根据节点值寻找节点索引步骤的时候，如有相同节点值的两个节点会寻找到同一个索引
     * @param root 前序根节点
     * @param left 中序左子树左边界 i-1 左子树右边界
     * @param right 中序右子树边界 i+1 右子树左边界
     * @return 当前节点
     */
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        /**
         * 左子树根节点 = 前序根节点+1
         */
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        /**
         * 右子树根节点 = 前序根节点 + 中序左子树长度 + 1
         */
        node.right = recur(root + (i - left) + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder= {9,3,15,20,7};
        RebuildTree rt = new RebuildTree();
        TreeNode treeNode = rt.buildTree(preorder, inorder);
    }
}
