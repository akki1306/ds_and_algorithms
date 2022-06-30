package stacksqueuesdeque;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../x/y/../z/././w/a///../../c/./"));
    }

    private static String simplifyPath(String input) {
        Stack<String> stack = new Stack<>();
        String[] split = input.split("/");
        for (int i = 0; i < split.length; i++) {
            if (!(split[i].equals("..") || split[i].equals(".") || split[i].equals("")))
                stack.push(split[i]);
            else {
                if (!stack.empty() && split[i].equals(".."))
                    stack.pop();
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + "/" + res;
        }
        res = "/" + res;
        if (res.charAt(res.length()-1) == '/' && res.length()>1)
            res = res.substring(0, res.length() - 1);
        return res;
    }
}
