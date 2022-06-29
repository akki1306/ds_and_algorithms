package stacksqueuesdeque;

import java.util.Stack;

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
