import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }
}

public class PermutationSequence {
    public static void main(String[] args) {
        int n = 4, k = 13;
        String str = new Solution().getPermutation(n, k);
        System.out.println(str);
    }
}