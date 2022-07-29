package udemy.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array containing N integers, find length of the longest band.
 * <p>
 * A band is defined as a subsequence which can be reordered in such a manner all elements
 * appear consecutive ( i.e. with absolute difference of 1 between neighbouring elements)
 * <p>
 * A longest band is a band (subsequence) which contains maximum integers.
 * <p>
 * Ex:
 * <p>
 * Input: [1,9,3,0,18,5,2,4,10,7,12,6]
 * Output: 8
 * <p>
 * Largest subset containing consecutive numbers: [0,1,2,3,4,5,6,7]s
 */
public class LongestBand {
    public static void main(String[] args) {
        System.out.println(findLengthOfLongestBand(new int[]{1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6}));
        System.out.println(findLengthOfLongestBand(new int[]{1, 9, 3, 0, 18, 5, 2, 10, 7, 12, 6}));
    }

    // time complexity O(N)
    // space complexity O(N)
    private static int findLengthOfLongestBand(int[] arr) {
        Set<Integer> set = new HashSet();

        for (Integer i : arr) {
            set.add(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            int cnt = 1;
            while (set.contains(v - 1)) {
                cnt++;
                max = Math.max(max, cnt);
                --v;
            }
        }
        return max;
    }
}
