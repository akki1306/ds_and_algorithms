package geeksforgeeks.sortingandsearching;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(medianOfTwoSortedArrays(new int[]{1}, new int[]{2, 3}, 1, 2));
    }

    private static double medianOfTwoSortedArrays(int[] arr1, int[] arr2, int m, int n) {
        if (m > n)
            return medianOfTwoSortedArrays(arr2, arr1, n, m);

        int low = 0, high = m, median = (m + n + 1) / 2;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = median - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1)
                if ((m + n) % 2 != 0)
                    return Math.max(l1, l2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            else if (l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;

        }
        return -1;
    }
}
