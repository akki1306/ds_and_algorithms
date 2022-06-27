package binarysearch;

public class RotatedSearch {
    public static void main(String[] args) {
        System.out.println(rotatedSearch(new int[]{7, 9, 10, 1, 2, 3, 4, 5, 6}, 10));
    }

    // modified binary search on array rotated around a pivot
    private static int rotatedSearch(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == element)
                return mid;
            else if (arr[0] <= arr[mid]) {
                if (element <= arr[mid] && element >= arr[start])
                    end = mid - 1;
                else {
                    start = mid + 1;
                }
            } else {
                if (element >= arr[mid] && element <= arr[end])
                    start = mid + 1;
                else{
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
