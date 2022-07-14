package sortingsearching;

import java.util.Arrays;

/**
 * Write a function that takes in an array and returns two integers, denoting starting and ending
 * indices of the smallest sub array in the input array that needs to be sorted in place so that
 * the entire input is sorted.
 *
 * If the input array is already sorted, then return {-1,-1}
 *
 * Sample Input:
 *
 * [0,2,4,7,10,11,7,12,13,14,16,19,29]
 *
 * Sample Output:
 *
 * [4,6]
 *
 * Explanation:
 *
 * If we sort the subarray[10,11,7] then entire array becomes sorted.
 */
public class SortingSubArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortingSubArray(new int[]{0, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 17, 29})));
        //System.out.println(Arrays.toString(sortingSubArray(new int[]{1, 2, 3, 10, 4, 2, 3, 5})));
        //  System.out.println(Arrays.toString(sortingSubArray(new int[]{5, 4, 3, 2, 1})));
        // System.out.println(Arrays.toString(sortingSubArray(new int[]{1, 2, 3})));
    }

    private static int[] sortingSubArray(int[] arr) {
        int N = arr.length;

        int start;
        for (start = 0; start < N - 1; start++)
            if (arr[start] > arr[start + 1])
                break;

        if (start == N - 1)
            return new int[]{-1, -1};

        int end;
        for (end = N - 1; end >= 1; end--)
            if (arr[end] < arr[end - 1])
                break;

        int maximum = arr[start];
        int minimum = arr[start];

        // Find the minimum and maximum element of unsorted array
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }

        for (int i = 0; i < start; i++) {
            if (arr[i] > minimum) {
                start = i;
                break;
            }
        }

        for (int i = N - 1; i >= end + 1; i--) {
            if (arr[i] < maximum) {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }
}
