package geeksforgeeks.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        System.out.println(kthSmallestPriorityQueue(new int[]{7, 10, 4, 3, 20, 15}, 0, 6, 3));
        System.out.println(kthSmallestQuickSelect(new int[]{7, 10, 4, 3, 20, 15}, 0, 6, 3));
    }

    // Time complexity - O(NLogK)
    // Space Complexity - O(N)
    private static int kthSmallestPriorityQueue(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Comparator.reverseOrder());
        q.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (q.size() < k) {
                q.add(arr[i]);
            } else {
                if (q.peek() > arr[i]) {
                    q.poll();
                    q.add(arr[i]);
                }
            }
        }

        return q.size() > 0 ? q.poll() : -1;
    }

    public static int kthSmallestQuickSelect(int[] arr, int l, int r, int k) {
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    private static int quickSelect(int[] arr, int s, int e, int lookup) {
        int partition = partition(arr, s, e);
        if (partition == lookup - 1)
            return arr[partition];
        if (lookup - 1 < partition)
            return quickSelect(arr, s, partition - 1, lookup);
        else
            return quickSelect(arr, partition + 1, e, lookup);
    }

    private static int partition(int[] arr, int s, int e) {
        int i = s - 1;
        int pivot = arr[e];
        for (int j = s; j <= e; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, e);
        return i + 1;
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
