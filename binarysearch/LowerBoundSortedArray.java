package binarysearch;

public class LowerBoundSortedArray {
    public static void main(String[] args) {
        System.out.println(lower_bound(new int[]{1, 2, 4, 5, 7, 9}, 5));
    }

    // lower bound is an element which is greater than or equal to the input element
    private static int lower_bound(int[] arr, int element) {
        int s = 0;
        int e = arr.length;
        int mid = -1;
        while (s != e) {
            mid = (s + e) / 2;
            if (arr[mid] < element)
                s = mid + 1;
            else
                e = mid;
        }

        if (mid == arr.length)
            return -1;

        return s;
    }
}
