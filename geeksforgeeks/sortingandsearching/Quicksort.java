package geeksforgeeks.sortingandsearching;

public class Quicksort {
    public static void main(String[] args) {
        System.out.println(quickSort(new int[]{7, 10, 4, 20, 15}, 0, 4, 4));
    }

    private static int quickSort(int[] arr, int s, int e, int lookup) {
        int partition = partition(arr, s, e);
        if (partition == lookup - 1)
            return arr[partition];
        if (lookup - 1 < partition)
            return quickSort(arr, s, partition - 1, lookup);
        else
            return quickSort(arr, partition + 1, e, lookup);
    }

    private static int partition(int[] arr, int s, int e) {
        int i = s - 1;
        int pivot = arr[e];
        for (int j = s; j <= e; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, e);
        return i + 1;
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
