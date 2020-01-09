class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x%10 == 0 && x != 0))
            return false;

        int rev = 0;
        int tmp = x;
        int remainder = 0;
        while (tmp != 0) {
            remainder = tmp % 10;
            rev = rev*10 + remainder;
            tmp /= 10;
        }

        return rev == x;
    }
}

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        boolean res = new Solution().isPalindrome(x);
        System.out.println(res);
    }
}