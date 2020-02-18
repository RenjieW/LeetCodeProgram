import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 || len2 == 0)
            return Math.max(len1, len2);

        int[][] dp = new int[len1+1][len2+1];
        int i = 0, j = 0;
        for (i = 0; i < len1+1; i++)
            dp[i][0] = i;
        for (j = 0; j < len2+1; j++)
            dp[0][j] = j;

        for (i = 0; i < len1; i++) {
            for (j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i+1][j+1] = dp[i][j];
                else {
                    dp[i+1][j+1] = 1 + Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]);
                }
            }
        }

        return dp[len1][len2];
    }
}

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        int res = new Solution().minDistance(word1, word2);
        System.out.println(res);
    }
}