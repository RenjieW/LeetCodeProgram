import java.util.*;

class Solution {
    private void backtrack(List<List<Integer>> output, int[] nums, ArrayList<Integer> curr, int first, int k, int n) {
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            curr.add(nums[i]);
            backtrack(output, nums, curr, i+1, k, n);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int n = nums.length;
        int k = 0;
        for (k = 0; k < n + 1; ++k) {
            backtrack(output, nums, new ArrayList<Integer>(), 0, k, n);
        }
        return output;
    }
}

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Solution().subsets(nums);
        System.out.println(res);
    }
}