package com.example.leetcode.sword.mid;

public class RobotMovingCount {
    int res = 0;
    boolean [][]visited;
    int m;
    int n;
    int k;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        dfs(0,0);
        return res;
    }

    void dfs(int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        visited[i][j] = true;
        if((sum(i) + sum(j)) <= k) {
            res++;
            // 当前节点可以访问，才能往接下来的节点走
            dfs(i+1,j);
            dfs(i,j+1);
        }
    }

    int sum(int x) {
        int res = 0;
        while(x != 0) {
            res += x % 10;
            x = x/10;
        }
        return res;
    }
}
