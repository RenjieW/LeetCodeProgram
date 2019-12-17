class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        int len = nums.length;
        int i=0, j=0;
        for (i=0; i<len; i++)
            for (j=i+1; j<len; j++)
                if (nums[i]+nums[j]==target) {
                    indices[0] = i;
                    indices[1] = j; 
                    return indices;
                }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] indices = new int[2];
        try {
            indices = twoSum(nums, target);
            System.out.printf("[%d,%d]\n", indices[0],indices[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}