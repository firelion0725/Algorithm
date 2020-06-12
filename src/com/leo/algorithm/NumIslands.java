package com.leo.algorithm;

public class NumIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;
        int result = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[j][i] == '1') {
                    dfs(grid, j, i, width, height);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int w, int h, int width, int height) {

        if (w < 0 || h < 0 || w >= width || h >= height || grid[w][h] == '0') {
            return;
        }

        grid[w][h] = '0';
        dfs(grid, w, h, width - 1, height);
        dfs(grid, w, h, width + 1, height);
        dfs(grid, w, h, width, height - 1);
        dfs(grid, w, h, width, height + 1);

    }

}
