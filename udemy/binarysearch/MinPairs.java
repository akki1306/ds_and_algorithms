package udemy.binarysearch;

import java.util.Arrays;

/**
 *
 * <b>Min Pairs</b>
 *
 * Given two non-empty udemy.arrays, find the pair of numbers (one from each array) whose
 * absolute difference is minimum. Print any one pair with the smallest difference.
 *
 * Sample Input:
 *
 * a1 = [-1, 5, 10, 20, 3]
 * a2 = [26, 134, 135, 15, 17]
 *
 * Sample Output:
 *
 * [20, 17]
 *
 *
 * Note: Lower bound is strictly greater than or equal to the element
 * Upper bound is strictly greater than the element.
 */
public class MinPairs {
    public static void main(String[] args) {
        //  System.out.println(Math.abs(Collections.binarySearch(l, 11) + 1));
        System.out.println(Arrays.toString(min_pair(new int[]{-1, 5, 10, 20, 3, 500}, new int[]{26, 134, 135, 15, 17})));
        //System.out.println(lower_bound(l, 16));
    }

    // linear search on one sorted array and binary search on another.
    private static int[] min_pair(int[] a1, int[] a2) {
        Arrays.sort(a2);

        int diff = Integer.MAX_VALUE;
        int[] pair = new int[2];
        for (int i = 0; i < a1.length; i++) {
            int lb = lower_bound(a2, a1[i]);

            // compare with element at lowerbound - 1
            if (lb >= 1 && (a1[i] - a2[lb - 1]) < diff) {
                diff = a1[i] - a2[lb - 1];
                pair[1] = a1[i];
                pair[0] = a2[lb - 1];
            }

            // compare with element at lower bound
            if (lb != a2.length && (a2[lb] - a1[i]) < diff) {
                diff = a2[lb] - a1[i];
                pair[1] = a2[lb];
                pair[0] = a1[i];
            }
        }
        return pair;
    }

    // 26, 134, 135, 15, 17
    // 15, 17, 26, 134, 135
    private static int lower_bound(int[] ar, int k) {
        int s = 0;
        int e = ar.length;
        while (s != e) {
            int mid = (s + e) / 2;
            if (ar[mid] < k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}
