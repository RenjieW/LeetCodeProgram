class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] splited = s.split(" ");
        return splited[splited.length-1].length();
    }
}

public class LengthOfLastWord {
    public static void main(String[] args) {
        String str = "Hello World";
        int len = new Solution().lengthOfLastWord(str);
        System.out.println(len);
    }
}