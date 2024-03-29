package udemy.stacksqueuesdeque;

import java.util.Stack;

/**
 * Given an expression udemy.string, write a program to check all the pairs of parantheses are valid.
 *
 * Input:
 *
 * ((a+b)*x - d)
 * ((a+b]+c)*(d-e)
 *
 * Output:
 *
 * True
 * False
 */
public class BalancedParantheses {
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        String s = "{((((a+b)*x -d)))}";
        char[] c = s.toCharArray();
        boolean isBalanced = true;
        for (char ch : c) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }

            if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }


            if (ch == ']') {
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }

            if (ch == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (!isBalanced)
            System.out.println("Not balanced");
        else
            System.out.println("Balanced parantheses");

    }

}
