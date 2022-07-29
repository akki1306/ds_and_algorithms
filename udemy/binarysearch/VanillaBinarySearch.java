package udemy.binarysearch;

public class VanillaBinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 1));
    }

    private static int binarySearch(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == element)
                return mid;
            else if (element < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;

        }

        return -1;
    }
}
