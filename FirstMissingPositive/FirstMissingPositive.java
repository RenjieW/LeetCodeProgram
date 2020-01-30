class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 1;

        // printArr(nums);
        int i = 0;

        while (i < nums.length){
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

        i = 0;
        while(i < nums.length && nums[i] == i+1) 
            i++;
        
        // printArr(nums);
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            System.out.printf("%d ", nums[i]);
        System.out.printf("\n");
    }
}

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int res = new Solution().firstMissingPositive(nums);
        System.out.println(res);
    }
}