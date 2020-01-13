import java.util.*; 

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length(), i = 0, num = 0;
        int digit = 0;

        for (i = 0; i < len; i++) {
            digit = map.get(s.charAt(i));
            if ((i+1<len) && (digit < map.get(s.charAt(i+1)))) {
                num += (map.get(s.charAt(i+1)) - digit);
                i++;
            }
            else
                num += digit;
            // System.out.printf("digit: %d, num: %d\n", digit, num);
        }

        return num;

    }
}

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int num = new Solution().romanToInt(s);
        System.out.println(num);
    }
}