package com.example.leetcode.sword.mid;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.res = new ArrayList<>();
        this.path = new LinkedList<>();
        recur(root,target);
        return res;
    }

    public void recur(TreeNode root, int target) {
        if(root == null) return;
        target -= root.val;
        path.add(root.val);
        if(target == 0 && root.left == null && root.right == null) {
            // 必须把new一个新的list，直接把path加进去最后回溯时path没有任何节点，res里也会没有任何节点，引用的同一个list对象
            res.add(new ArrayList<>(path));
        }
        recur(root.left,target);
        recur(root.right,target);
        // 回溯时path减掉最后一个节点，target += root.val
        path.removeLast();
    }
}
