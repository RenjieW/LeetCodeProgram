import java.util.*;

class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (s == null || len == 0)
            return true;

        Map<Character, Integer> mapping = new HashMap<Character, Integer>();
        mapping.put('(', 0);
        mapping.put('[', 1);
        mapping.put('{', 2);
        mapping.put('}', 3);
        mapping.put(']', 4);
        mapping.put(')', 5);
        Stack<Integer> stack = new Stack<Integer>();

        char chr;
        int num = 0, stacknum = 0;

        for (int i = 0; i < len; i++) {
            num = mapping.get(s.charAt(i));
            if (num <= 2)
                stack.push(num);
            else {
                if (stack.empty())
                    return false;
                stacknum = stack.pop();
                if (num+stacknum != 5)
                    return false;
            }
        }

        if (stack.empty())
            return true;
        else
            return false;
    }
}

public class ValidParentheses {
    public static void main(String[] args) {
        String brackets = "()[]{}";
        boolean isvalid = new Solution().isValid(brackets);
        System.out.println(isvalid);
    }
}