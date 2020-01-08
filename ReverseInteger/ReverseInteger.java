class Solution {
    public int reverse(int x) {
        int rev = 0;
        int remainder = 0;
        while (x != 0) {
            remainder = x % 10;
            x /= 10;
            if ((rev > Integer.MAX_VALUE/10) || (rev == Integer.MAX_VALUE/10 && remainder>7))
                return 0;
            if ((rev < Integer.MIN_VALUE/10) || (rev == Integer.MIN_VALUE/10 && remainder<-8))
                return 0;

            rev = rev*10 + remainder;
        }
        return rev;
    }
}

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        int rev = new Solution().reverse(x);
        System.out.println(rev);
    }
}