class Solution {
    public int strStr(String haystack, String needle) {
        int stacklen = haystack.length();
        int needlelen = needle.length();
        
        if (needlelen == 0)
            return 0;       
        if (stacklen == 0)
            return -1;

        int i = 0, j = 0;
        for (i = 0; i < stacklen-needlelen + 1; i++) 
            for (j = 0; j < needlelen; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if(haystack.charAt(i+j) == needle.charAt(j) && j == needlelen-1)
                    return i;
            }

        return -1;
    }
}

public class ImplementStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        int index = new Solution().strStr(haystack, needle);
        System.out.println(index);
    }
}