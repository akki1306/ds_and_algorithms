package geeksforgeeks.sortingandsearching;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 5, 2, 3, 1};
        System.out.println(inversionCount(arr, 0, arr.length - 1));
    }

    private static int inversionCount(int[] arr, int s, int e) {
        if (s >= e)
            return 0;

        int mid = (s + e) / 2;
        int c1 = inversionCount(arr, s, mid);
        int c2 = inversionCount(arr, mid + 1, e);
        int c3 = merge(arr, s, e);
        return c1 + c2 + c3;
    }

    private static int merge(int[] arr, int s, int e) {
        int i = s;
        int mid = (s + e) / 2;
        int j = mid + 1;

        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                result.add(arr[i++]);
            } else {
                cnt += mid - i + 1;
                result.add(arr[j++]);
            }
        }

        while (i <= mid) {
            result.add(arr[i++]);
        }

        while (j <= e) {
            result.add(arr[j++]);
        }

        i = 0;
        for (int k = s; k <= e; k++) {
            arr[k] = result.get(i++);
        }
        return cnt;
    }
}
