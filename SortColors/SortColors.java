import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return;
        int i = 0, start = 0, end = len - 1;

        while (i <= end && start <= end) {
            // System.out.printf("%s, %d, %d\n", Arrays.toString(nums), start, end);
            if (nums[i] == 0) {
                if (nums[start] == 0) {
                    i++;
                } else {
                    swap(nums, i, start);
                }
                start++;
            } else if (nums[i] == 2) {
                if (nums[end] != 2) {
                    swap(nums, i, end);
                }
                end--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}