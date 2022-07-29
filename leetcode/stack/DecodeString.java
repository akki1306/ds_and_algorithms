package leetcode.stack;

import java.util.Stack;

// Leetcode 394
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
               System.out.println(decodeString("3[a2[c]]"));
             System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                String repeatChar = "";
                while (!st.isEmpty() && st.peek() != '[') {
                    repeatChar = st.pop() + repeatChar;
                }
                st.pop();
                String repeatCountStr = "";
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    repeatCountStr = st.pop() + repeatCountStr;
                }
                int repeatCount = Integer.valueOf(repeatCountStr);
                String res = "";
                while(repeatCount-->0){
                    res += repeatChar;
                }

                for(int j=0;j<res.length();j++){
                    st.push(res.charAt(j));
                }
            } else {
                st.push(ch);
            }
        }

        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}
