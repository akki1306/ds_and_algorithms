package binarysearch;

public class UpperBoundSortedArray {
    public static void main(String[] args) {
        System.out.println(upper_bound(new int[]{1, 2, 5, 6, 7, 9}, 6));
    }

    // upper bound returns and element from the array that is strictly greater than the input element.
    private static int upper_bound(int[] arr, int element) {
        int s = 0;
        int e = arr.length;
        while (s != e) {
            int mid = (s + e) / 2;
            if (arr[mid] < element) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        if (s == arr.length)
            return -1;

        return s;
    }
}
