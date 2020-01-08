class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        int i = 0, j = 0;
        for (i = 0; i < numRows; i++) {
            for (j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j+i));
                if ((i != 0) && (i != numRows-1) && (j + cycleLen - i < n))
                    ret.append(s.charAt(j+cycleLen-i));
            }
        }

        return ret.toString();
    }
}

public class ZigZagConversion {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String res = new Solution().convert(str, 3);
        System.out.println(res);
    }
}