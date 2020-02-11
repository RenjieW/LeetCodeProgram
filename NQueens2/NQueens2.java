import java.util.*;

class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        int i = 0, j = 0;
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                board[i][j] = '.';

        DFS(board, 0);
        return count;
    }

    private void DFS(char[][] board, int col) {
        if (col == board.length) {
            count++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (valuidate(board, i, col)) {
                board[i][col] = 'Q';
                DFS(board, col+1);
                board[i][col] = '.';
            }
        }
    }

    private boolean valuidate(char[][] board, int row, int col) {
        int i = 0, j = 0;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < col; j++) {
                if (board[i][j] == 'Q' && (row == i || Math.abs(row-i) == Math.abs(col-j)))
                    return false;
            }
        }
        return true;
    }
}

public class NQueens2 {
    public static void main(String[] args) {
        int n = 4;
        int res = new Solution().totalNQueens(n);
        System.out.println(res);
    }
}