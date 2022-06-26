package binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinPairs {
    public static void main(String[] args) {
        //  System.out.println(Math.abs(Collections.binarySearch(l, 11) + 1));
        System.out.println(Arrays.toString(min_pair(Arrays.asList(-1, 5, 10, 20, 3), Arrays.asList(26, 134, 135, 15, 17))));
        //System.out.println(lower_bound(l, 16));
    }

    public static int[] min_pair(List<Integer> a1, List<Integer> a2) {
        Collections.sort(a2);

        int[] pair = new int[2];
        int diff = Integer.MAX_VALUE;
        for (int x : a1) {
            int lb = lower_bound(a2, x);

            //left
            // check difference with one element just before the insert position returned by lower bound
            if (lb >= 1 && x - a2.get(lb - 1) < diff) {
                diff = x - a2.get(lb - 1);
                pair[1] = x;
                pair[0] = a2.get(lb - 1);
            }
            //greater / right
            // check difference with the element at insert position returned by lower bound
            if (lb != a2.size() && a2.get(lb) - x < diff) {
                diff = a2.get(lb) - x;
                pair[0] = x;
                pair[1] = a2.get(lb);
            }

        }
        return pair;
    }

    // 26, 134, 135, 15, 17
    // 15, 17, 26, 134, 135
    private static int lower_bound(List<Integer> ar, int k) {
        int s = 0;
        int e = ar.size();
        while (s != e) {
            int mid = (s + e) / 2;
            if (ar.get(mid) < k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.size()) {
            return -1;
        }
        return s;
    }
}
