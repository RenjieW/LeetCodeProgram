class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        if (rowLen == 0)
            return false;
        int colLen = matrix[0].length;
        int left = 0, right = colLen;
        int mid = 0;

        for (int i = 0; i < rowLen; i++) {
            left = 0;
            right = colLen-1;
            while (left <= right) {
                mid = (left + right) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                          {10, 11, 16, 20},
                          {23, 30, 34, 50}};
        int target = 3;
        boolean res = new Solution().searchMatrix(matrix, target);
        System.out.println(res);
    }
}