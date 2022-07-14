package binarysearch;

/**
 * Given a sorted array which can contain repeated elements, and an element K
 * we need to find frequency of a given element.
 *
 * Input Array:
 * [0,1,1,1,1,2,2,2,3,4,4,5,10]
 * Key=3
 *
 * Output: 3
 *
 */
public class FrequencyCount {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 10};
        System.out.println(upperBound(arr, 3) - lowerBound(arr, 3));
    }

    private static int lowerBound(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int mid = -1, ans = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == element) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] > element)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return ans;
    }

    private static int upperBound(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int mid, ans = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == element) {
                ans = mid;
                start = mid + 1;
            } else if (arr[mid] > element)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return ans;
    }
}
