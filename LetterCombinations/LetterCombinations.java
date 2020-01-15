import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        int len = digits.length();
        if (len == 0)
            return res;

        String[] mapping = new String[] {" ", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

        int i = 0, j = 0, k = 0;;
        int letterslen = 0;
        String letters = "";

        for (i = 0; i < len; i++) {
            letters = mapping[digits.charAt(i)-'0'];
            // System.out.println(letters);
            List<String> sub = new ArrayList<String>();
            letterslen = letters.length();

            for (j = 0; j < letterslen; j++) {
                if (res.isEmpty())
                    res.add("");
                // for (k = 0 ; k < res.size(); k++) {
                //     sub.add(res.get(k) + letters.charAt(j));
                // }    
                for (String s : res) {
                    sub.add(s + letters.charAt(j));
                }
            }
            res = sub;        
            // System.out.println(res);   
        }

        return res;
    }
}

public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = new Solution().letterCombinations(digits);
        System.out.println(res);
    }
}