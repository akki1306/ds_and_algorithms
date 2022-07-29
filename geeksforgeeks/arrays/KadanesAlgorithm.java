package geeksforgeeks.arrays;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{1, 2, 3, -2, 5}, 5));
    }

    static long maxSubarraySum(int arr[], int n) {
        long max = Long.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}
