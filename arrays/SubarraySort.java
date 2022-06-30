package arrays;

import java.util.Arrays;

public class SubarraySort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSubArraySortIndicesSorting(new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10})));
        System.out.println(Arrays.toString(findSubArraySortIndicesLinear(new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10})));
    }

    // Space Complexity - O(n)
    // Time Complexity - O(NLogN)
    private static int[] findSubArraySortIndicesSorting(int[] arr) {
        int n = arr.length;
        int[] copyArr = Arrays.copyOf(arr, n);

        Arrays.sort(copyArr);

        int i = 1;
        while (i < n && arr[i] == copyArr[i])
            i++;

        int j = n - 1;
        while (j >= 0 && arr[j] == copyArr[j])
            j--;

        if (i == n - 1)
            return new int[]{-1, -1};

        return new int[]{i, j};
    }

    private static boolean isOutOfOrder(int[] arr, int index) {
        if (index == 0) {
            return arr[1] < arr[index];
        }

        if (index == arr.length - 1) {
            return arr[index] < arr[index - 1];
        }

        return arr[index + 1] < arr[index] || arr[index - 1] > arr[index];
    }

    // time complexity - O(n)
    // space complexity - O(1)
    private static int[] findSubArraySortIndicesLinear(int[] arr) {
        int n = arr.length;

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (isOutOfOrder(arr, i)) {
                smallest = Math.min(smallest, arr[i]);
                largest = Math.max(largest, arr[i]);
            }
        }

        if (smallest == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = n - 1;

        while (smallest >= arr[left])
            left++;

        while (largest <= arr[right])
            right--;

        return new int[]{left, right};
    }

}
