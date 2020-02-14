class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        if (rowLen == 0)
            return 0;
        int colLen = obstacleGrid[0].length;
        int[][] dp = new int[rowLen][colLen];
        int i = 0, j = 0;

        for (i = 0; i < rowLen; i++)
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else
                break;

        for (j = 0; j < colLen; j++)
            if (obstacleGrid[0][j] == 0)
                dp[0][j] = 1;
            else
                break;

        for (i = 1; i < rowLen; i++)
            for (j = 1; j < colLen; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }

        return dp[rowLen-1][colLen-1];
    }
}

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int res = new Solution().uniquePathsWithObstacles(grid);
        System.out.println(res);
    }
}