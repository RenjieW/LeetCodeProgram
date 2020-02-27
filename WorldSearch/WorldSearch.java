class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;

        int rowLen = board.length, colLen = board[0].length;
        int i = 0, j = 0;
        char[] w = word.toCharArray();
        for (i = 0; i < rowLen; i++) {
            for (j = 0; j < colLen; j++) {
                if (search(board, w, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, char[] word, int index, int i, int j) {
        if (index == word.length)
            return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length)
            return false;
        if (board[i][j] != word[index])
            return false;

        board[i][j] ^= 256;
        boolean flag = search(board, word, index+1, i, j+1)
                    || search(board, word, index+1, i, j-1)
                    || search(board, word, index+1, i+1, j)
                    || search(board, word, index+1, i-1, j);
        board[i][j] ^= 256;
        return flag;
    }
}

public class WorldSearch {
    public static void main(String[] args) {
        char[][] board = {
                            {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}
                         };
        String word = "ABCCED";
        boolean res = new Solution().exist(board, word);
        System.out.println(res);
    }   
}