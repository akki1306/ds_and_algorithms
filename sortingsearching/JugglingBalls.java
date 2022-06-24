package sortingsearching;

import java.util.Arrays;

public class JugglingBalls {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 2, 0, 1, 2, 0};
        jugglingBalls(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void jugglingBalls(int[] arr) {
        int N = arr.length;
        int start = 0, mid = 0;
        int end = N - 1;
        int pivot = 1;

        while (mid <= end) {
            if (arr[mid] < pivot) {
                swap(arr, start, mid);
                ++start;
                ++mid;
            } else if (arr[mid] > pivot) {
                swap(arr, mid, end);
                --end;
            } else {
                ++mid;
            }
        }
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
