import java.io.*;

class Solution {
    public int myAtoi(String str) {
        char[] chrAry = str.toCharArray();
        int index = 0;
        int n = chrAry.length;
        boolean negative = false;
        int res = 0;
        int digit = 0;
        if (n == 0)
            return 0;

        while (index < n && chrAry[index] == ' ') {
            index++;
        }

        if (index >= n)
            return 0;

        if (chrAry[index] == '+')
            index++;
        else if (chrAry[index] == '-') {
            negative = true;
            index++;
        }
        else if (chrAry[index]<'0' || chrAry[index]>'9')
            return 0;

        while (index<n && chrAry[index]>='0' && chrAry[index]<='9') {
            digit = chrAry[index] - '0';

            if (!negative && (res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && digit>7))
                return Integer.MAX_VALUE;
            if (negative && (res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && digit>8))
                return Integer.MIN_VALUE;

            res = res*10 + digit;
            index++;
        }

        return negative ? -res : res;
    }
}

public class StringToInteger {
    public static void main(String[] args) {
        String str = "   -42";
        int res = new Solution().myAtoi(str);
        System.out.println(res);
    }
}