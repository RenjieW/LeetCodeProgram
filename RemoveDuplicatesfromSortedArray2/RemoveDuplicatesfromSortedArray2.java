class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int count = 1, index = 1, curr = nums[0];
        int i = 0;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] == curr) {
                if (count == 2)
                    continue;
                else {
                    nums[index] = nums[i];
                    index += 1;
                    count++;
                }  
            } else {
                count = 1;
                curr = nums[i];
                nums[index] = nums[i];
                index += 1;
            }
        }

        printArr(nums, index);
        return index;
    }

    private void printArr(int[] nums, int len) {
        for (int i = 0; i < len; i++)
            System.out.printf("%d ", nums[i]);
        System.out.printf("\n");
    }
}

public class RemoveDuplicatesfromSortedArray2 {
    public static void main(String[] args) {
         int[] nums = {0,0,1,1,1,1,2,3,3};
         int len = new Solution().removeDuplicates(nums);
    }
}