import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        if (rowLen == 0)
            return;
        int colLen = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        int i = 0, j = 0;

        for (i = 0; i < rowLen; i++) {
            for (j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (i = 0; i < rowLen; i++) {
            for (j = 0; j < colLen; j++) {
                if (rows.contains(i) || cols.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, 
                          {1, 0, 1},
                          {1, 1, 1}};
        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}