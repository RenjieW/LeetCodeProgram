import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combineHelper(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    private void combineHelper(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            combineHelper(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}

public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = new Solution().combine(n, k);
        System.out.println(res);
    }
}