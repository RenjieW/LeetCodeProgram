import java.util.*;

class DPSolution {
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(')
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i - 1] + 2 +(i - dp[i - 1] >= 2 ? dp[i - dp[i-1] - 2] : 0);
            }
            else
                dp[i] = 0;

            maxlen = Math.max(maxlen, dp[i]);
        } 

        return maxlen;
    }
}

// class StackSolution{
//     public int longestValidParentheses(String s) {
//         return 0;
//     }
// }

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = ")()())";
        int ans = new DPSolution().longestValidParentheses(s);
        System.out.println(ans);
        // ans = new StackSolution().longestValidParentheses(s);
        // System.out.println(ans);
    }    
}