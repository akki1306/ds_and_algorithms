package arrays;

/**
 * Implement a function that takes an input vector of integers, and prints the maximum subarray sum
 * that can be formed. A sub array is is defined as consecutive segment of the array. If all numbers
 * are negative then return zero.
 * <p>
 * Input:
 * <p>
 * {-1,2,3,4,-2,6,-8,3}
 */
public class MaximumSubArraySum {
    public static void main(String[] args) {
        System.out.println(maximumSubArraySum(new int[]{-1, 2, 3, 4, -2, 6, -8, 3}));
    }

    // time complexity - O(N)
    // space complexity - O(N)
    private static int maximumSubArraySum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}
