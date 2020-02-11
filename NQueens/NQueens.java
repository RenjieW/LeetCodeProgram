import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        int i = 0, j = 0;
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<List<String>>();
        DFS(board, 0, res);
        return res;
    }

    private void DFS(char[][] board, int col, List<List<String>> res) {
        if (col == board.length) {
            res.add(constructRes(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (valuidate(board, i, col)) {
                board[i][col] = 'Q';
                DFS(board, col+1, res);
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

    private List<String> constructRes(char[][] board) {
        ArrayList<String> tempsol = new ArrayList<String>();       
        for (int i = 0; i < board.length; i++) {
            String rowvalue = new String(board[i]);
            tempsol.add(rowvalue);
        }
        return tempsol;
    }
}

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = new Solution().solveNQueens(n);
        System.out.println(res);
    }
}