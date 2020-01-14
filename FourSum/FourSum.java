import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (k == 2) {
            int left = start, right = len - 1;
            int sum = 0;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> sub = new ArrayList<Integer>();
                    sub.add(nums[left]);
                    sub.add(nums[right]);
                    res.add(sub);

                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    while (left < right && nums[right] == nums[right-1])
                        right--;

                    left++;
                    right--;
                }
                else if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        else {
            for (int i = start; i < len - (k-1); i++) {
                if (i > start && nums[i] == nums[i-1])
                    continue;

                List<List<Integer>> temp = kSum(nums, i+1, k-1, target-nums[i]);
                for (List<Integer> t : temp) 
                    t.add(0, nums[i]);

                res.addAll(temp);
            }
        }

        return res;
    }
}

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = new Solution().fourSum(nums, 0);
        System.out.println(res);
    }
}