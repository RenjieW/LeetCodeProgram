class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        if (n < 0) {
            if( n == Integer.MIN_VALUE ) {
                ++n;
                // System.out.println(n);
                n = -n;
                x = 1/x;
                return x * x * myPow( x * x, n / 2 );
            }
            n = -n;
            x = 1 / x;
        }

        if (n % 2 == 0)
            return myPow(x*x, n/2);
        else
            return x * myPow(x*x, n/2);
    }
}

public class Pow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        double res = new Solution().myPow(x, n);
        System.out.println(res);
    }
}