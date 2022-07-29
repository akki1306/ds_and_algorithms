package udemy.priorityqueue;

import java.util.PriorityQueue;

/**
 * Merging Ropes
 *
 * Given N Ropes each having a different size, your task is join the ropes together.
 * The cost of joining 2 ropes of different sizes X and Y is (X+Y). Find the minimum
 * cost to join all the ropes together.
 *
 * Input:
 * N=4
 * Ropes[] = {4 3 2 6};
 *
 * Output:
 * 29
 */
public class MergingRopes {
    public static void main(String[] args) {
        System.out.println(mergingRopesCost(new int[]{4, 3, 2, 6}));
    }

    private static int mergingRopesCost(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        int sum = 0;
        while (queue.size() > 1) {
            int s = queue.poll() + queue.poll();
            sum += s;
            queue.add(s);
        }

        return sum;
    }
}
