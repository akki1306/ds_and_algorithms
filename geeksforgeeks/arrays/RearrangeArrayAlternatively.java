package geeksforgeeks.arrays;

import java.util.Arrays;

public class RearrangeArrayAlternatively {
    public static void main(String[] args) {
        //long[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        long[] arr = {1, 2, 3, 4, 5};
        rearrange(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(long arr[], int n) {
        // initialize index of first minimum and first
        // maximum element
        int max_idx = n - 1, min_idx = 0;

        // store maximum element of array
        long max_elem = arr[n - 1] + 1;

        // traverse array elements
        for (int i = 0; i < n; i++) {
            // at even index : we have to put
            // maximum element
            if (i % 2 == 0) {
                long delta = (arr[max_idx] % max_elem) * max_elem;
                arr[i] += delta;
                max_idx--;
            }

            // at odd index : we have to put minimum element
            else {
                long delta = (arr[min_idx] % max_elem) * max_elem;
                arr[i] += delta;
                min_idx++;
            }
        }

        // array elements back to it's original form
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / max_elem;
    }
}
