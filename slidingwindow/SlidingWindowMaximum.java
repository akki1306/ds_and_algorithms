package slidingwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of integers and an integer K, return a vector containing maximum for
 * each and every continguous subarray of size k.
 *
 * Constraints:
 * -10000 <=A[i]<=10000, where 0<i<size of array
 *  K>0
 * Sample Input:
 * K=3
 * input = {1,2,3,1,4,5,2,3,6}
 * output = {3,3,4,5,5,5,6}
 *
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(slidingWindowMaximumSizeK(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3));
    }

    private static List<Integer> slidingWindowMaximumSizeK(int[] s, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < s.length; i++) {
            maxHeap.add(s[i]);
            minHeap.add(s[i]);
            if (maxHeap.size() == 3) {
                result.add(maxHeap.peek());
                maxHeap.remove(s[i - k + 1]);
                minHeap.remove(s[i - k + 1]);
            }
        }
        return result;
    }
}
