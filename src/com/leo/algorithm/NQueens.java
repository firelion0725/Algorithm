package com.leo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {


    int n;
    List<List<String>> result = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            list.add(sb.toString());
        }
        backTrack(0);
        return result;
    }

    private void backTrack(int row) {
        if (row == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(row, col)) {
                continue;
            }
            setChar(row, col, 'Q');
            backTrack(row + 1);
            setChar(row, col, '.');
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (list.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (list.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, --j) {
            if (list.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void setChar(int row, int col, char c) {
        StringBuilder stringBuffer = new StringBuilder(list.get(row));
        stringBuffer.setCharAt(col, c);
        list.set(row, stringBuffer.toString());
    }
}
