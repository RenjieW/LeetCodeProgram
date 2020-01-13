class Solution {
    public boolean isMatch(String text, String pattern) {
        int len_t = text.length(), len_p = pattern.length();
        boolean[][] dp = new boolean[len_t+1][len_p+1];
        int i = 0, j = 0;
        boolean first_match;
        dp[len_t][len_p] = true;

        for (i = len_t; i >= 0; i--) {
            for (j = len_p-1; j >= 0; j--) {
                first_match = (i<len_t) && ((pattern.charAt(j)==text.charAt(i)) || (pattern.charAt(j)=='.'));
                if (j+1<pattern.length() && pattern.charAt(j+1)=='*')
                    dp[i][j] = dp[i][j+2] || (first_match && dp[i+1][j]);
                else
                    dp[i][j] = first_match && dp[i+1][j+1];
            }
        }

        return dp[0][0];
    }
}

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean res = new Solution().isMatch(s, p);
        System.out.println(res);
    }
}