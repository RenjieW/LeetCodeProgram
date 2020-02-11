import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int lvalue = newInterval[0], rvalue = newInterval[1];
        int[][] resarr;
        if (intervals.length == 0) {
            resarr = new int[1][2];
            resarr[0] = newInterval;
            return resarr; 
        }
        int i = 0;
        List<int[]> leftList = new ArrayList<>(), rightList = new ArrayList<>();

        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < lvalue)
                leftList.add(intervals[i]);
            else if (intervals[i][0] > rvalue)
                rightList.add(intervals[i]);
            else {
                lvalue = Math.min(lvalue, intervals[i][0]);
                rvalue = Math.max(rvalue, intervals[i][1]);
            }
        }
        int[] interval = {lvalue, rvalue};
        leftList.add(interval);
        leftList.addAll(rightList);

        resarr = new int[leftList.size()][2];
        for (i = 0; i < resarr.length; i++)
            resarr[i] = leftList.get(i);
        return resarr;
    }
}

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4, 8};
        int[][] res = new Solution().insert(intervals, newInterval);
    }
}