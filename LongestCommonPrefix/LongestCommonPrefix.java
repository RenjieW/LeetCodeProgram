class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (strs == null || len == 0)
            return "";

        int i = 0, j = 0;
        char chr;
        for (i = 0; i < strs[0].length(); i++) {
            chr = strs[0].charAt(i);
            for (j = 1; j < len; j++) {
                if (i >= strs[j].length() || chr != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String commonprefix = new Solution().longestCommonPrefix(strs);
        System.out.println(commonprefix);
    }
}