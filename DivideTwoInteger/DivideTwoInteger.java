class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) 
            return Integer.MAX_VALUE;

        if (dividend > 0 && divisor > 0)
            return divideHelper(-dividend, -divisor);
        else if (dividend > 0)
            return -divideHelper(-dividend, divisor);
        else if (divisor > 0)
            return -divideHelper(dividend, -divisor);
        else
            return divideHelper(dividend, divisor);
    }

    private int divideHelper(int divident, int divisor) {
        int res = 0;
        int currentDivisor = divisor;
        while(true) {
            if (divident > divisor)
                break;

            int temp = 1;
            while (divident <= currentDivisor << 1 && currentDivisor << 1 < 0) {
                temp = temp << 1;
                currentDivisor = currentDivisor << 1;
            }

            divident -= currentDivisor;
            res += temp;
            currentDivisor = divisor;
        }

        return res;
    }
}

public class DivideTwoInteger {
    public static void main(String[] args) {
        int divident = 10, divisor = 3;
        int quotient = new Solution().divide(divident, divisor);
        System.out.println(quotient);
    }
}