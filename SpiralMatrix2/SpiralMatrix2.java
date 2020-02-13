class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[0][0];

        int[][] matrix = new int[n][n];
        // printMatrix(matrix);

        int temprow = 0, tempcol = 0;
        int row = 0, col = 0;
        int i = 0, di = 0;
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};
        for (i = 0; i < n * n; i++) {
            matrix[row][col] = i+1;
            temprow = row + drow[di];
            tempcol = col + dcol[di];
            if (temprow >= 0 && temprow <= n-1 && tempcol >= 0 && tempcol <= n-1 && matrix[temprow][tempcol] == 0) {
                row = temprow;
                col = tempcol;
            } else {
                di = (di + 1) % 4;
                row += drow[di];
                col += dcol[di];
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    private void printMatrix(int[][] matrix) {
        if (matrix.length == 0)
            return;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%d, ", matrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
}

public class SpiralMatrix2 {
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = new Solution().generateMatrix(n);
    }
}