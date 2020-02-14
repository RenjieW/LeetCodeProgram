import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        if (rowLen == 0)
            return 0;
        int colLen = grid[0].length;

        int[][] dp = new int[rowLen][colLen];
        int i = 0, j = 0;
        dp[0][0] = grid[0][0];
        for (i = 1; i < rowLen; i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for (j = 1; j < colLen; j++)
            dp[0][j] = dp[0][j-1] + grid[0][j];

        for (i = 1; i < rowLen; i++) {
            for (j = 1; j < colLen; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rowLen-1][colLen-1];
    }
}

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = new Solution().minPathSum(grid);
        System.out.println(res);
    }
}