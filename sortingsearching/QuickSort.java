package sortingsearching;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 0, 7, 6, 4};
        quickSort(arr, 0,6);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Algorithm Steps
     * 1. Choose a pivot - last element
     * 2. Partition your arrray using pivot element
     * 3. Recursively sort left part of the array and right part.
     */
    private static void quickSort(int[] arr, int s, int e) {
        if (s >= e)
            return;

        //Recursive case
        int p = partition(arr, s, e);
        quickSort(arr, s, p - 1);
        quickSort(arr, p + 1, e);
    }

    private static int partition(int[] arr, int s, int e) {
        int i = s - 1;
        int pivot = arr[e];
        for (int j = s; j < e; j++) { // loop to find correct position for the pivot element
            if (arr[j] < pivot) {
                i++;                // variable i is incremented only for all elements less than pivot.
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, e);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
