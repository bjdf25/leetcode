package com.example.leetcode.sword;

/**
 * 矩阵中的路径
 */
public class RoadInTheMatrix {
    char[] word;
    public boolean exist(char[][] board, String k) {
        this.word = k.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 穷举遍历每一个节点
                if (dfs(board, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        // 将当前节点置为空，使得当前链路中的下次递归遍历到该节点的时候直接返回false(题目规定同一个单元格内的字母不允许被重复使用。)
        board[i][j] = ' ';
        boolean res = dfs(board, i + 1, j, k + 1) || dfs(board, i - 1, j, k + 1)
                || dfs(board, i, j - 1, k + 1) || dfs(board, i, j + 1, k + 1);
        // 当前链路遍历完成之后重置该节点，避免回溯的时候遇到该节点就直接返回false了（回溯时遇到该节点又是新的一条链路了）
        board[i][j] = word[k];
        return res;
    }
}
