package arrays;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        System.out.println(maximumSubArraySum(new int[]{-1, 2, 3, 4, -2, 6, -8, 3}));
    }

    // time complexity - O(N)
    // space complexity - O(N)
    private static int maximumSubArraySum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];

        // calculate prefix sum
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = arr[i] + prefixSum[i - 1];

        int max = Integer.MIN_VALUE;
        int minPrefixSum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, prefixSum[i] - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
