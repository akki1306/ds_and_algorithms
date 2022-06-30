package priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSubarrayHeap {
    public static void main(String[] args) {
        System.out.println(maxSubArraySlidingWindowDeque(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3));
    }

    private static List<Integer> maxSubArraySlidingWindowDeque(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            if (cnt <= k) {
                queue.add(arr[i]);
                cnt++;
            }

            if(queue.size() == k){
                result.add(queue.peek());
                queue.remove(arr[i-k+1]);
                cnt--;
            }
        }
        return result;
    }
}
