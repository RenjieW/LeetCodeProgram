class Solution {
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int res = new Solution().jump(nums);
        System.out.println(res);
    }
}