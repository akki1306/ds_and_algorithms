package geeksforgeeks.sortingandsearching;

public class SumOfMiddleElementsOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMidSum(new int[]{5, 10, 12, 16, 17, 18, 22, 24, 27, 29, 29, 29},
                new int[]{5, 7, 9, 10, 10, 13, 16, 18, 20, 22, 26, 29}, 12));
    }

    private static int findMidSum(int[] ar1, int[] ar2, int n) {
        if (n == 1)
            return ar1[0] + ar2[0];

        int low = 0, high = n;
        int median = (n + n + 1) /  2;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = median - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : ar1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : ar2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : ar1[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : ar2[cut2];

            if (l1 <= r2 && l2 <= r1)
                return Math.max(l1, l2) + Math.min(r1, r2);
            else if (l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }
        return -1;
    }
}
