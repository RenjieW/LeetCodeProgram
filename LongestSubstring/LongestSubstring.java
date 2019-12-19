import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), maxL = 0;
        int i, j;
        Map<Character, Integer> map = new HashMap<>();

        for (i=0,j=0; j<len; j++) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(j)), i);

            maxL = Math.max(maxL, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return maxL;
    }
}

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int maxLen = new Solution().lengthOfLongestSubstring(s);
        System.out.println(maxLen);
    }
}