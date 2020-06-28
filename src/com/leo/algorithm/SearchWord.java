package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/word-search/
 */
class SearchWord {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        SearchWord s = new SearchWord();
        s.exist(board, "SEE");
    }

    public boolean exist(char[][] board, String word) {

        if (board.length == 0 || word.length() == 0) {
            return false;
        }

        int raw = board.length;
        int col = board[0].length;
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                if (hasWordInBoard(board, word, j, i, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasWordInBoard(char[][] board, String word, int x, int y, int count) {
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) {
            return false;
        }
        if (board[y][x] != word.charAt(count)) {
            return false;
        }

        if (count == word.length() - 1) {
            return true;
        }
        char temp = board[y][x];
        board[y][x] = '$';

        boolean up = hasWordInBoard(board, word, x, y - 1, count + 1);
        if (up) {
            board[y][x] = temp;
            return true;
        }

        boolean left = hasWordInBoard(board, word, x - 1, y, count + 1);
        if (left) {
            board[y][x] = temp;
            return true;
        }

        boolean down = hasWordInBoard(board, word, x, y + 1, count + 1);
        if (down) {
            board[y][x] = temp;
            return true;
        }

        boolean right = hasWordInBoard(board, word, x + 1, y, count + 1);
        if (right) {
            board[y][x] = temp;
            return true;
        }
        board[y][x] = temp;
        return false;
    }
}