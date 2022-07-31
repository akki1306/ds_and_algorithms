package geeksforgeeks.sortingandsearching;

public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(kthElementOfTwoSortedArrays(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5, 4, 5));
    }

    private static int kthElementOfTwoSortedArrays(int[] arr1, int[] arr2, int n, int m, int k) {
        if (m > n)
            return kthElementOfTwoSortedArrays(arr2, arr1, n, m, k);

        int low = Math.max(0, k - m), high = Math.min(k, n);
        while (low <= high) {
            int cut1 = (low + high) >> 1; // divided by 2
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}
