package stacksqueuesdeque;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        // System.out.println(simplifyPath("/../x/y/../z/././w/a///../../c/./"));
        System.out.println(simplifyPath("/../../a/b/./c"));
    }

    private static String simplifyPath(String input) {
        Stack<String> stack = new Stack<>();
        String[] tokens = Arrays.stream(input.split("/")).filter(e -> !e.equals("") && !e.equals(".")).toArray(size -> new String[size]);

        // handle corner case for relative path and if the path starts with a "/" then put a place holder in stack
        if (input.charAt(0) == '/')
            stack.push("");

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("..")) {
                // absolute path case
                if (stack.empty() || stack.get(0).equals(".."))
                    stack.push("..");
                else if (!stack.get(0).equals(""))
                    stack.pop();
            } else {
                stack.push(tokens[i]);
            }
        }

        if (stack.get(0).equals("") && stack.size() == 1)
            return "/";

        String res = "";

        int i = 0;
        for (String s : stack) {
            if (i <= stack.size() - 1)
                res = res + s + "/";
            else
                res = res + s;
            i++;
        }

        return res;
    }
}
