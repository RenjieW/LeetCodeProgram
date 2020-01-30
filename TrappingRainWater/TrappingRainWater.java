import java.util.*;

class DPSolution {
    public int trap(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return 0;

        int[] left_max = new int[len];
        int[] right_max = new int[len];
        left_max[0] = nums[0];
        right_max[len-1] = nums[len-1];

        int i = 0;
        int volume = 0, min_max = 0;
        for (i = 1; i < len; i++)
            left_max[i] = Math.max(left_max[i-1], nums[i]);
        for (i = len - 2; i >= 0; i--)
            right_max[i] = Math.max(right_max[i+1], nums[i]);

        for (i = 1; i < len-1; i++) {
            min_max = Math.min(left_max[i], right_max[i]);
            volume += (min_max > nums[i] ? min_max-nums[i] : 0);
        }

        return volume;
    }
}

class TwoPointerSolution {
    public int trap(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return 0;

        int left = 0, right = len-1;
        int left_max = 0, right_max = 0;
        int volume = 0;

        while (left < right) {
            if (nums[left] < nums[right]) {
                if (nums[left] < left_max)
                    volume += left_max - nums[left];
                else 
                    left_max = nums[left];
                left++;
            }
            else {
                if (nums[right] < right_max) 
                    volume += right_max - nums[right];
                else
                    right_max = nums[right];
                right--;
            }
        }

        return volume;
    }
}

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res1 = new DPSolution().trap(nums);
        System.out.println(res1);
        int res2 = new TwoPointerSolution().trap(nums);
        System.out.println(res2);
    }
}