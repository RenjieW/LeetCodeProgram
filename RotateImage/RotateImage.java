class Solution {
    public void rotate(int[][] matrix) {
        int i = 0, j = 0;
        int temp = 0;
        int row = matrix.length, col = matrix[0].length; 
        for (i = 0; i < row/2; i++)
            for (j = 0; j < col; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[row-i-1][j];
                matrix[row-i-1][j] = temp;
            }

        for (i = 0; i < row; i++)
            for (j = i; j < col; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }
}

public class RotateImage {
    public static void main(String[] args) {
        int[][] 
    }
}