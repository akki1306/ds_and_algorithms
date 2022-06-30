package stacksqueuesdeque;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        System.out.println(stockSpan(new int[]{100, 80, 60, 70, 60, 75, 85}));
    }

    private static List<Integer> stockSpan(int[] arr) {
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            // remove all elements smaller than the current element
            while (!s.empty() && arr[s.peek()] <= arr[i])
                s.pop();

            if (s.empty())
                ans.add(i + 1); // if stack empty then number of elements smaller than current element will be i + 1
            else {
                int top = s.peek();
                ans.add(i - top); // if stack is not empty then number of elements smaller than current element will be i + st.peek()
            }
            s.push(i); // push every index to the stack
        }

        return ans;
    }
}
