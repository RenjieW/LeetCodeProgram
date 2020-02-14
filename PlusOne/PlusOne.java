import java.util.*;

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0)
            return new int[] {1};

        if (digits[len-1] != 9) {
            digits[len-1] += 1;
            return digits;
        }

        digits[len-1] = 0;
        int carry = 1;
        int i = 0;

        for (i = len-2; i >= 0; i--) {
            if (digits[i] + carry <= 9) {
                digits[i] += carry;
                break;
            }
            else {
                digits[i] = 0;
                carry = 1;
            }
        }

        if (i >= 0)
            return digits;
        else {
            int[] newNum = new int[len+1];
            newNum[0] = 1;
            for (i = 0; i < len; i++)
                newNum[i+1] = digits[i];
            return newNum;
        }

    }
}

public class PlusOne {
    public static void main(String[] args) {
        int[] num = {9, 9, 9};
        int[] newNum = new Solution().plusOne(num);
        System.out.println(Arrays.toString(newNum));
    }
}