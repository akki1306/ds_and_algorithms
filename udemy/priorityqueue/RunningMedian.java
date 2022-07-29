package udemy.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Running Median
 *
 * You are given a running stream of integers. Write an efficient algorithm
 * to output median of numbers read so far after every input.
 *
 * Sample Input:
 *
 * 10 5 2 3 0 12 18 20 22
 *
 * Sample Output:
 *
 * 10 7.5 5 4 3 4 5 7.5 10
 */
public class RunningMedian {
    public static void main(String[] args) {
        System.out.println(runningMedian(new int[]{5, 10, 2, 3, 0, 12, 18, 20, 22}));
    }

    private static List<Float> runningMedian(int[] num) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();   // store all elements greater than median in min heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // store all elements less than median in max heap
        List<Float> result = new ArrayList<>(); // to store results

        float med = num[0];
        result.add(med); // for the first element median is the number itself
        maxHeap.add(num[0]); // add first element to max heap

        for (int i = 1; i < num.length; i++) {
            if (maxHeap.size() > minHeap.size()) { // if elements less than median are more than the ones greater than median
                if (num[i] < med) {             // if element to be added qualifies to be added to max heap
                    minHeap.add(maxHeap.poll());   // mode topmost element from max heap and add to min heap
                    maxHeap.add(num[i]);            // add current element to max heap
                } else {
                    minHeap.add(num[i]);        // if element to be added qualifies to be added to min heap
                }
                med = (minHeap.peek() + maxHeap.peek()) / 2.0f;  // calculate the average of topmost element of both heaps as they contain equal number
            } else if (maxHeap.size() == minHeap.size()) { // if both heap contain equal number of elements
                if (num[i] < med) {                     // if current number qualifies to be added to max heap
                    maxHeap.add(num[i]);                // add current element to max heap
                    med = maxHeap.peek();               // pick median from the max heap since the total number of elements so far are odd in number
                } else {                                // current element will be populated in min heap
                    minHeap.add(num[i]);                // add current to min heap
                    med = minHeap.peek();               // pick median from min heap since total number of elements so far are odd in number.
                }
            } else {                                // if elements more than median are greater than the ones less than median
                if (num[i] < med) {                 // if current element is less than median
                    maxHeap.add(num[i]);            // add current element to max heap
                } else {                            // if current element is greater than median
                    minHeap.add(num[i]);            // add current element to min heap
                    maxHeap.add(minHeap.poll());    // rebalance heap
                }
                med = (minHeap.peek() + maxHeap.peek()) / 2.0f; // both heaps now contain equal number of elements hence take average
            }
            result.add(med);
        }
        return result;
    }
}
