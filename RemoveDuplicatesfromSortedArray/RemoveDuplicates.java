class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len;

        int i = 0, curr = 1;
        int currval = nums[0];

        for (i = 1; i < len; i++) {
            if (currval != nums[i]) {
                currval = nums[i];
                nums[curr] = nums[i];
                curr++;
            }
        }

        return curr;
    }
}

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = new Solution().removeDuplicates(nums);
        for (int i = 0; i < len; i++)
            System.out.printf("%d ", nums[i]);
        System.out.printf("\n");
    }
}