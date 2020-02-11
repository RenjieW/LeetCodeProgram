import java.util.*;

class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len1 == 0 || len2 == 0)
            return "0";
        int tempsum = 0, tempmul = 0;
        int pos[] = new int[len1+len2];
        int i = 0, j = 0;

        for (i = len1 - 1; i >= 0; i--) 
            for (j = len2 -1; j >= 0; j--) {
                tempmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                tempsum = tempmul + pos[i+j+1];
                pos[i+j] += tempsum / 10;
                pos[i+j+1] = tempsum % 10;
            }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) 
            if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();

    }
}

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String res = new Solution().multiply(num1, num2);
        System.out.println(res);
    }
}