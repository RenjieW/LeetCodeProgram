class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] range = {-1, -1};
        if (len == 0)
            return range;

        int l = 0, r = len - 1, mid = 0;
        int lindex = -1, rindex = -1;
        

        while (l <= r) {
            mid = (l+r) / 2;
            System.out.println(nums[mid]);
            if (nums[mid] == target) {
                lindex = mid;
                rindex = mid;
                while (lindex >= 1 && nums[lindex-1] == target)
                    lindex--;

                while (rindex <= len-2 && nums[rindex+1] == target)
                    rindex++;

                break;
            }
            else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        range[0] = lindex;
        range[1] = rindex;
        // System.out.println(lindex);
        // System.out.println(rindex);
        return range;
    }
}

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 4};
        int target = 4;
        int[] indices = new Solution().searchRange(nums, target);
        System.out.printf("[%d, %d]\n", indices[0], indices[1]);
    }
}