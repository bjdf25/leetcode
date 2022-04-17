package com.example.leetcode.sword.easy;

import com.example.leetcode.common.TreeNode;

/**
 * I. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证节点p一定小于节点q，便于比较，简略写法
        // 也可以不用写，比较的时候if (root.val > q.val && root.val > p.val) (root.val < q.val && root.val < p.val)
        if (p.val > q.val) {
            TreeNode temp = q;
            q = p;
            p = temp;
        }
        while(root != null) {
            if (root.val > q.val) {
                root = root.left;
                continue;
            }
            if (root.val < p.val) {
                root = root.right;
                continue;
            }
            return root;
        }
        return root;
    }

    public TreeNode lowestCommonAncestorByIterable(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > q.val && root.val > p.val) {
            return lowestCommonAncestorByIterable(root.left, p, q);
        }
        if (root.val < q.val && root.val < p.val) {
            return lowestCommonAncestorByIterable(root.right, p, q);
        }
        return root;
    }
}
