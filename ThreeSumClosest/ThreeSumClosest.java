import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (nums == null || len == 0)
            return 0;
        int i = 0, j = 0, k = 0;
        int sum = 0, res = nums[0] + nums[1] + nums[len-1];;

        Arrays.sort(nums);

        for (i = 0; i < len-2; i++) {
            j = i + 1;
            k = len - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum < target)
                    j++;
                else if (sum > target)
                    k--;
                else
                    return target;

                if (Math.abs(sum-target) < Math.abs(res-target))
                    res = sum;
            }
        }
        
        return res;
    }
}

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int res = new Solution().threeSumClosest(nums, target);
        System.out.println(res);
    }
}