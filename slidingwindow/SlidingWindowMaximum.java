package slidingwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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
