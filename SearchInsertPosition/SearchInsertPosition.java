import java.util.*;
import java.io.*;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return 0;

        int l = 0, r = len - 1, mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                l = mid + 1;

            if (nums[mid] > target)
                r = mid - 1;
        }
        if (nums[mid] < target)
            return mid + 1;
        else 
            return mid;
    }
}

public class SearchInsertPosition {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            
            int ret = new Solution().searchInsert(nums, target);
            
            String out = String.valueOf(ret);
            
            System.out.println(out);
        }
    }
}