import java.util.*;

enum Index {
    GOOD, BAD, UNKNOWN 
}

class Solution {
    public boolean canJump(int[] nums) {
        Index[] dp = new Index[nums.length];
        int i = 0, j = 0, len = nums.length;
        int pos = 0;
        int furthestpos = 0;
        for (i = 0; i < len-1; i++)
            dp[i] = Index.UNKNOWN;
        dp[len-1] = Index.GOOD;

        for (i = len - 2; i >=0; i--) {
            furthestpos = Math.min(i + nums[i], len-1);
            for (j = i+1; j <= furthestpos; j++)
                if (dp[j] == Index.GOOD) {
                    dp[i] = Index.GOOD;
                    break;
                }
        }

        return dp[0] == Index.GOOD;
    }
}

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean res = new Solution().canJump(nums);
        System.out.println(res);
    }
}
