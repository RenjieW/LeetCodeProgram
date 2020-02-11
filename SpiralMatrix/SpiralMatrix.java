import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0)
            return res;

        int rowLen = matrix.length, colLen = matrix[0].length;
        boolean seen[][] = new boolean[rowLen][colLen];
        int row = 0, col = 0, temprow = 0, tempcol = 0;
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};
        int i = 0, di = 0;

        for (i = 0; i < rowLen * colLen; i++) {
            seen[row][col] = true;
            res.add(matrix[row][col]);
            temprow = row + drow[di];
            tempcol = col + dcol[di];
            if (temprow >= 0 && temprow < rowLen && tempcol >= 0 && tempcol < colLen && !seen[temprow][tempcol]) {
                row = temprow;
                col = tempcol;
            } else {
                di = (di + 1) % 4;
                row += drow[di];
                col += dcol[di];
            }
        }
        return res;
    }
}

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9,10,11,12}
                         };
        List<Integer> res = new Solution().spiralOrder(matrix);
        System.out.println(res);
    }
}