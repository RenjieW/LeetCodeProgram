class Solution {
    public int search(int[] A, int target) {
        int len = A.length;
        if (len == 0)
            return -1;
        int l = 0, r = len - 1;
        int mid = 0;
        while (l < r) {
            mid = (l+r) / 2;
            if (target == A[mid])
                return mid;

            if (A[l] <= A[mid]) {
                if (target >= A[l] && target <= A[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            else {
                if (target >= A[mid] && target <= A[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        return A[l]==target ? l : -1;
    }
}

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] A = {4,5,6,7,0,1,2};
        int target = 0;
        int index = new Solution().search(A, target);
        System.out.println(index);
    }
}