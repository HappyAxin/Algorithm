package com.xin.checkerboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/n-queens/">51. N皇后</a>
 * @Date 2023/05/16
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(board, 0, solution);
        return solution;
    }

    private void backtrack(char[][] board, int row, List<List<String>> solutions) {
        if (row == board.length) {
            solutions.add(constructSolution(board));
            return;
        }

        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, solutions);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        // 检查当前列是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上方斜线是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方斜线是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

}
