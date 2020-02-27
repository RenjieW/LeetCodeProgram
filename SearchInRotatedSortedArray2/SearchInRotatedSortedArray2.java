class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        int left = 0, right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;
            
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else 
                    left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else
                left++;
        }
        return false;
    }
}

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        boolean res = new Solution().search(nums, target);
        System.out.println(res);
    }
}