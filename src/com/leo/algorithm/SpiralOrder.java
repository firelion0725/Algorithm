package com.leo.algorithm;

public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralOrder s = new SpiralOrder();
        s.spiralOrder2(matrix);
    }

    /**
     * 官方解法 + 个人注释
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        //设定边界
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];

        int row = 0, column = 0;
        //四个方向             列+1右移 行+1下移  列-1左移  行-1上移
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            //给结果集赋值 并记录 是否访问
            order[i] = matrix[row][column];
            visited[row][column] = true;
            //下一个位置
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }


    /**
     * 这个解 比第一个好理解 速度还快
     * @param matrix
     * @return
     */
    public int[] spiralOrder2(int[][] matrix) {

        if (matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, x = 0;
        // 左边界， 右边界， 上边界， 下边界
        int[] res = new int[matrix.length * matrix[0].length];//存储结果的数组

        while (true) {
            for (int i = left; i <= right; i++) {
                //从左边界 往 右边界
                res[x++] = matrix[top][i];
            }
            if (++top > bottom) {
                // 上边界下移1 (大于下边界则越界)
                break;
            }
            for (int i = top; i <= bottom; i++) {
                //从上边界 往 下边界
                res[x++] = matrix[i][right];
            }
            if (left > --right) {
                // 右边界左移1 (小于左边界则越界)
                break;
            }
            for (int i = right; i >= left; i--) {
                // 从右边界 往 左边界
                res[x++] = matrix[bottom][i];
            }
            if (top > --bottom) {
                // 下边界上移1 (小于上边界则越界)
                break;
            }
            for (int i = bottom; i >= top; i--) {
                // 从下边界 往 上边界
                res[x++] = matrix[i][left];
            }
            if (++left > right) {
                // 左边界右移1 (大于右边界则越界)
                break;
            }
        }
        return res;


    }
}
