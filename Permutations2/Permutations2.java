import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, used);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true || i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            tempList.add(nums[i]);
            used[i] = true;
            backtrack(list, tempList, nums, used);
            tempList.remove(tempList.size()-1);
            used[i] = false;
        }
    }
}

public class Permutations2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = new Solution().permuteUnique(nums);
        System.out.println(res);
    }
}