package com.leo.algorithm;

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

}
