package udemy.stacksqueuesdeque;

import java.util.Stack;

/**
 * Redundant Paranthesis
 *
 * Given a udemy.string of balanced expression, find if it contains redundant
 * paranthesis or not. A set of paranthesis are redundant if same sub-expression
 * is sorrounded by unnecessary or multiple brackets. Print 'Yes' if redundant else
 * 'No'
 *
 *  Input               Output
 *
 *  ((a+b))             Yes
 *  (a+(b)/c)           Yes
 *  (a+b*(c-d))         No
 *
 * Hint: If there is no operator in between the brackets then the brackets are redundant
 */
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
