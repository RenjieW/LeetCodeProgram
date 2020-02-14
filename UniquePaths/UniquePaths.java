class Solution {
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        int i = 0, j = 0;
        for (i = 0; i < m; i++)
            nums[i][0] = 1;
        for (j = 0; j < n; j++)
            nums[0][j] = 1;

        for (i = 1; i < m; i++)
            for (j = 1; j < n; j++)
                nums[i][j] = nums[i-1][j] + nums[i][j-1];

        return nums[m-1][n-1];
    }
}

public class UniquePaths {
    public static void main(String[] args) {
        int m = 7, n = 3;
        int res = new Solution().uniquePaths(m, n);
        System.out.println(res);
    }
}