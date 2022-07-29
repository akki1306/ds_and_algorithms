package geeksforgeeks.stacksandqueues;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        System.out.println(max_of_subarrays(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 9, 3));
    }

    //Function to find maximum of each subarray of size k.
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> list = new ArrayList();
        ArrayDeque<Integer> q = new ArrayDeque();
        int i = 0;
        for (; i < k; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i])
                q.pollLast();

            q.addLast(i);
        }

        for (; i < n; i++) {
            list.add(arr[q.peekFirst()]);

            while (!q.isEmpty() && q.peekFirst() <= i - k)
                q.pollFirst();

            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i])
                q.pollLast();

            q.addLast(i);
        }
        list.add(arr[q.pollFirst()]);
        return list;
    }
}
