import java.io.*;

class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0, right = 0;
        dp[n-1][n-1] = true;
        for (int i = n-2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i+1; j < n; j++) {
                if ((j-i)==1)
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    dp[i][j] = (dp[i+1][j-1]) && (s.charAt(i) == s.charAt(j));

                if (dp[i][j] && (right-left<j-i)) {
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right+1);
    }
}

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String ret = new Solution().longestPalindrome(s);
        System.out.println(ret);
    }
}