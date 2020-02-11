import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0)
            return new int[0][0];
        int i = 0;
        int[] temparr;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);
        for (i = 1; i < len; i++) {
            temparr = res.get(res.size()-1);
            if (temparr[1] < intervals[i][0])
                res.add(intervals[i]);
            else {
                temparr[1] = temparr[1] > intervals[i][1] ? temparr[1] : intervals[i][1];
            }
        }

        int[][] resArr = new int[res.size()][2];
        for (i = 0; i < resArr.length; i++)
            resArr[i] = res.get(i);

        printArr(resArr);
        return resArr;
    }

    private void printArr(int[][] arr) {
        int rowLen = arr.length;
        if (rowLen == 0)
            return;
        int colLen = arr[0].length;
        int i = 0, j = 0;
        for (i = 0; i < rowLen; i++) {
            for (j = 0; j < colLen; j++) 
                System.out.printf("%d,", arr[i][j]);
            System.out.printf(" \n");
        }
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new Solution().merge(intervals);
        // System.out.println(res);
    }
}