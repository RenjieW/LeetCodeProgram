import java.util.*;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int alen = a.length(), blen = b.length();
        int carry = 0;
        int sum = 0;
        int i = alen-1, j = blen-1;
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }
}

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String res = new Solution().addBinary(a, b);
        System.out.println(res);
    }
}