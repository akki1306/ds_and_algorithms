package udemy.sortingsearching;

import java.util.ArrayList;
import java.util.List;

public class InversionCount {
    public static void main(String[] args) {
        System.out.println(inversion_count(new int[]{0,5,2,3,1}, 0, 4));
    }

    private static int inversion_count(int[] arr, int s, int e) {
        if (s >= e)
            return 0;

        int mid = (s + e) / 2;

        int c1 = inversion_count(arr, s, mid);
        int c2 = inversion_count(arr, mid + 1, e);
        int ci = merge(arr, s, e);
        return c1 + c2 + ci;
    }

    private static int merge(int[] arr, int s, int e) {
        int i = s;
        int m = (s + e) / 2;
        int j = m + 1;

        List<Integer> results = new ArrayList();

        int cnt = 0;
        while (i <= m && j <= e) {
            if (arr[i] < arr[j]) {
                results.add(arr[i++]);
            } else {
                cnt += m - i + 1;
                results.add(arr[j++]);
            }
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

        return cnt;
    }
}
