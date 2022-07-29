package udemy.slidingwindow;

import java.util.HashMap;

public class CountSubArraysTargetSum {
    public static void main(String[] args) {
        System.out.println(countSubArraysTargetSum(new int[]{10, 2, -2, -20, 10}, -10));
    }

    private static int countSubArraysTargetSum(int[] a, int K) {
        int n = a.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        int count = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i]; // increment prefix sum till ith element.
            if (sum == K) {
                count++;      // found sub array with sum K
            }
            if (hash.get(sum - K) != null) { // find if there are existing elements in hashmap with sum equal to K
                count += hash.get(sum - K);
            }
            if (hash.get(sum) != null) {        // else put the new sum in the hashmap
                hash.put(sum, hash.get(sum) + 1); // increment if already present
            } else {
                hash.put(sum, 1);       // put a new value
            }
        }
        return count;
    }
}
