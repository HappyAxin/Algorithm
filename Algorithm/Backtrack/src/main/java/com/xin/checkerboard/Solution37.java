package com.xin.checkerboard;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/sudoku-solver/">37. 解数独</a>
 * @Date 2023/05/16
 */
public class Solution37 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solve(board)) {
                                return true;
                            }
                            // 回溯
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int n = board.length;

        // 检查行
        for (int i = 0; i < n; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // 检查列
        for (int i = 0; i < n; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // 检查 3x3 宫格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
