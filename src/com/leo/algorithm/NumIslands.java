package com.leo.algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        //纵坐标系
        int height = grid.length;
        //横坐标系
        int width = grid[0].length;
        int result = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, j, i, width, height);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int w, int h, int width, int height) {

        if (w < 0 || h < 0 || w >= width || h >= height || grid[h][w] == '0') {
            return;
        }

        grid[h][w] = '0';
        dfs(grid, w + 1, h, width, height);
        dfs(grid, w - 1, h, width, height);
        dfs(grid, w, h + 1, width, height);
        dfs(grid, w, h - 1, width, height);

    }

    //==============================并查集==============================================

    public static void main(String[] args) {
        char[][] nums = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        NumIslands n = new NumIslands();
        n.numIslandsOffice(nums);
    }

    public int numIslandsOffice(char[][] grid) {
        int y = grid.length;
        int x = grid[0].length;

        int allLength = x * y;

        UnionFind unionFind = new UnionFind(allLength);

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    //判断是否为陆地
                    if (j < x - 1 && grid[i][j + 1] == '1') {
                        unionFind.union(i * x + j, i * x + j + 1);
                    }

                    if (i < y - 1 && grid[i + 1][j] == '1') {
                        unionFind.union(i * x + j, (i + 1) * x + j);
                    }
                } else {
                    //判断是否为海水
                    if (j < x - 1 && grid[i][j + 1] == '0') {
                        unionFind.union(i * x + j, i * x + j + 1);
                    }

                    if (i < y - 1 && grid[i + 1][j] == '0') {
                        unionFind.union(i * x + j, (i + 1) * x + j);
                    }
                }
            }
        }
        //这个是陆地和海水合并的总计 要减去海水的集合数 海水的集合数怎么算呢？
        return unionFind.getCount();
    }

    class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                count--;
            }
        }


        public int getCount() {
            return count;
        }

        public int[] getParent() {
            return parent;
        }
    }

    //=======================================================

    class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0) return 0;
            int x = grid.length;
            int y = grid[0].length;

            int[] nums = new int[x * y];
            Arrays.fill(nums, -1);

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == '1') {
                        grid[i][j] = '0';

                        //判断下侧是否有陆地
                        if (i < (x - 1) && grid[i + 1][j] == '1') {
                            union(nums, i * y + j, (i + 1) * y + j);
                        }

                        //判断右侧是否有陆地
                        if (j < (y - 1) && grid[i][j + 1] == '1') {
                            union(nums, i * y + j, i * y + j + 1);
                        }
                    } else {
                        nums[i * y + j] = -2;
                    }
                }
            }

            int count = 0;
            for (int num : nums) {
                if (num == -1) count++;
            }

            return count;
        }

        public int find(int[] parents, int i) {
            if (parents[i] == -1) {
                return i;
            }

            return find(parents, parents[i]);
        }

        public void union(int[] parents, int x, int y) {
            int xset = find(parents, x);
            int yset = find(parents, y);
            if (xset != yset) {
                parents[xset] = yset;
            }
        }
    }

//===================================================================

    public int numIslands2(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int ans = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visit);
                    ans++;
                }
            }
        }
        return ans;
    }

    void dfs(char[][] grid, int n, int m, boolean[][] visit) {
        if (n >= grid.length || n < 0 || m >= grid[0].length || m < 0) {
            return;
        }
        if (visit[n][m] || grid[n][m] == '0') {
            return;
        }
        visit[n][m] = true;
        dfs(grid, n + 1, m, visit);
        dfs(grid, n, m + 1, visit);
        dfs(grid, n - 1, m, visit);
        dfs(grid, n, m - 1, visit);
    }
}
