class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        int i = 0, j = 0;

        dp[len1][len2] = true;
        for (j = len2 - 1; j >= 0; j--) {
            if (p.charAt(j) != '*')
                break;
            else
                dp[len1][j] = true;
        }

        for (i = len1-1; i >= 0; i--) {
            for (j = len2-1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    dp[i][j] = dp[i+1][j+1];
                else if (p.charAt(j) == '*')
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[0][0];
    }
}

public class WildcardMatching {
    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        boolean res = new Solution().isMatch(s, p);
        System.out.println(res);
    }
}