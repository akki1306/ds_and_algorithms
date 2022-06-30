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
            while (!s.empty() && arr[s.peek()] <= arr[i])
                s.pop();

            if (s.empty())
                ans.add(i + 1);
            else {
                int top = s.peek();
                ans.add(i - top);
            }
            s.push(i);
        }

        return ans;
    }
}
