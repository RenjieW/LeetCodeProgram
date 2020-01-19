class Solution {
    public int removeElement(int[] nums, int val) {
        int i, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = new Solution().removeElement(nums, 2);
        for (int i = 0; i < len; i++)
            System.out.printf("%d ", nums[i]);
        System.out.printf("\n");
    }
}