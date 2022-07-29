package udemy.sortingsearching;

/**
 * Write a function that takes input an array of distinct integers, and returns kth smallest
 * in the array.
 *
 * Sample Input:
 *
 * [10,5,2,0,7,6,4]
 * k=4
 *
 * Sample Output:
 * 5
 *
 */
public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 0, 7, 6, 4};
        System.out.println(arr[quickSelect(arr,0,6, 4)]);
    }

    private static int quickSelect(int[] arr, int s, int e, int k) {
        if (s >= e)
            return s;

        //Recursive case
        int p = partition(arr, s, e);
        if (p == k - 1)
            return p;
        else if (p < k - 1)
            return quickSelect(arr, p + 1, e, k);
        else
            return quickSelect(arr, s, p - 1, k);
    }

    private static int partition(int[] arr, int s, int e) {
        int i = s - 1;
        int pivot = arr[e];
        for (int j = s; j < e; j++) { // loop to find correct position for the pivot element
            if (arr[j] < pivot) {
                i++;                // variable i is incremented only for all elements less than pivot.
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, e);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
