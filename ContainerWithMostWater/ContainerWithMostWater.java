import java.lang.Math;

class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length-1;
        int temparea = 0;
        
        while (l < r) { 
            temparea = (r-l) * Math.min(height[l], height[r]);
            maxarea = Math.max(maxarea, temparea);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return maxarea;
    }
}

public class ContainerWithMostWater {
    public static void main(String[] args) {
        // int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,2,8,3,1,2};
        int area = new Solution().maxArea(height);
        System.out.println(area);
    }
}