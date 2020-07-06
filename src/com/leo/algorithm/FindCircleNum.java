package com.leo.algorithm;

import com.leo.algorithm.model.UnionFind;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        int y = M.length;
        int x = M[0].length;
        UnionFind unionFind = new UnionFind(x * y);

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x - 1; j++) {
                int data = M[i][j];
                if (data == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }
}
