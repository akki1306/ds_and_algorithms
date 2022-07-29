package udemy.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Triplets in GP
 *
 * You are given an array and you need to count number of triplets with indices (i,j,k) such that
 * the elements at those indices are in geometric progression for a given common ratio r and i(i<j<k)
 */
public class TripletsInGP {
    public static void main(String[] args) {
        System.out.println(countTripletsInGP(new int[]{1, 16, 4, 16, 64, 16}, 4));
    }

    // slider with udemy.hashing
    // time complexity - O(n)
    private static int countTripletsInGP(int[] arr, int r) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i : arr) {
            right.put(i, right. getOrDefault(i, 0) + 1); // include frequencies of all characters in right array.
            left.put(i, 0); // keep frequency as zero for all characters in left array.
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            // remove from the right side map
            right.put(arr[i], right.get(arr[i]) - 1);

            // contribution of current element to our answer
            if (arr[i] % r == 0) {
                int b = arr[i];
                int a = b / r;
                int c = b * r;
                ans += left.getOrDefault(a, 0) * right.getOrDefault(c,0);
            }

            // add the element and increase the count to the left side of the array
            left.put(arr[i], left.getOrDefault(arr[i], 0) + 1);
        }
        return ans;
    }
}
