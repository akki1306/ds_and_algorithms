package stacksqueuesdeque;

import java.util.Stack;

public class RedundantParanthesis {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = "((a+b) + (c))";
        char[] c = s.toCharArray();
        boolean operator = false;
        for (char ch : c) {
            if (!(ch == ')')) {
                stack.push(ch);
            } else {
                operator = false;
                if (ch == ')') {
                    while (stack.peek() != '(') {
                        if (stack.peek() == '+' || stack.peek() == '*' || stack.peek() == '-' || stack.peek() == '/')
                            operator = true;

                        stack.pop();
                    }
                    if (!operator)
                        break;

                    if (stack.peek() == '(')
                        stack.pop();
                }
            }
        }
        System.out.println("Redundant : " + !operator);
    }

}
