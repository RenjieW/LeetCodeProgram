class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}  

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        printArr(nums);
        new Solution().nextPermutation(nums);
        printArr(nums);
    }

    public static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) 
            System.out.printf("%d ", nums[i]);
        System.out.printf("\n"); 
    }
}