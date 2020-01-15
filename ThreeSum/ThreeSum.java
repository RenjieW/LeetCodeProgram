import java.util.*;

class Solution {
    List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        if (nums == null || nums.length==0)
            return res;

        Arrays.sort(nums);

        for (i = 0; i+2 < len; i++) {
            if (nums[i] > 0)
                break;
            else if (i > 0 && nums[i] == nums[i-1])
                continue;
            j = i + 1;
            k = len - 1;

            while (j < k) {
                if (nums[i]+nums[j]+nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1])
                        j++;
                    while (j < k && nums[k] == nums[k+1])
                        k--;
                }
                else if (nums[i]+nums[j]+nums[k] < 0) 
                    j++;
                else
                    k--;
            }
        }
        return res;
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new Solution().threeSum(nums);
        System.out.println(res);
    }
}