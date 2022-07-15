package stacksqueuesdeque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Max Subarray
 *
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 *
 * Sample Input:
 *
 * N = 9
 * arr[] = {1 2 3 1 4 5 2 3 6}
 * k=3
 *
 * Output:
 *
 * 3 3 4 5 5 5 6
 */
public class MaxSubArraySlidingWindowDeque {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6, 7}, 3));
    }

    private static List<Integer> maxSubArray(int[] arr, int slidingWindowSize) {
        Deque<Integer> d = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        // for initial k elements
        int i;
        for (i = 0; i < slidingWindowSize; i++) {
            while (!d.isEmpty() && d.peekLast() < arr[i])
                d.pollLast();

            d.addLast(i);
        }

        // for elements from k+1 to n
        for (; i < arr.length; i++) {
            // first element in the queue is always the largest element in the sliding window as per the logic implemented below.
            result.add(arr[d.peekFirst()]);

            // contract from left to slide window and remove elements falling outside window
            while (!d.isEmpty() && d.peekFirst() <= i - slidingWindowSize)
                d.pollFirst();

            // expand right by removing elements that are less than current element and keeping only relevant largest elements found so far.
            while (!d.isEmpty() && arr[d.peekLast()] <= arr[i])
                d.pollLast();

            d.addLast(i);
        }

        result.add(arr[d.pollFirst()]);
        return result;
    }
}
