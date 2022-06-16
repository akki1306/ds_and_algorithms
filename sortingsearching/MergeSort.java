package sortingsearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 2, 0, 7, 6, 4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int s, int e) {
        if (s >= e)
            return;

        int mid = (s + e) / 2;

        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, s, e);
    }

    private static void merge(int[] arr, int s, int e) {
        int i = s;
        int m = (s + e) / 2;
        int j = m + 1;

        List<Integer> results = new ArrayList();

        while (i <= m && j <= e) {
            if (arr[i] < arr[j])
                results.add(arr[i++]);
            else
                results.add(arr[j++]);
        }

        while (i <= m) {
            results.add(arr[i++]);
        }

        while (j <= e) {
            results.add(arr[j++]);
        }

        i = 0;
        for (int k = s; k <= e; k++) {
            arr[k] = results.get(i++);
        }
    }
}
