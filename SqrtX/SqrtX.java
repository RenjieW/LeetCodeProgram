class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid > x/mid)
                right = mid - 1;
            else {
                if (mid+1 > x/(mid+1))
                    return mid;
                left = mid + 1;
            }

        }
        return (left+right)/2;
    }
}

public class SqrtX {
    public static void main(String[] args) {
        int x = 8;
        int res = new Solution().mySqrt(x);
        System.out.println(res);
    }
}