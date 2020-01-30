import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int index) {
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i-1])
                    continue;
                tempList.add(candidates[i]);
                backtrack(list, tempList, candidates, remain-candidates[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = new Solution().combinationSum2(candidates, target);
        System.out.println(res);
    }
}