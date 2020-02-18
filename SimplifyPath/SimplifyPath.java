import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        if (path.isEmpty())
            return path;

        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");

        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            }
            else if (directory.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else {
                stack.add(directory);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        String simplifyPath = new Solution().simplifyPath(path);
        System.out.println(simplifyPath);          
    }
}