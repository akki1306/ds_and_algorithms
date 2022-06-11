package arrays;

import java.util.Arrays;

// Leetcode 1877
public class MinimizeMaximumPairSum {
    public static void main(String[] args) {
        System.out.println(minPairSum(new int[]{3,5,4,2,4,6}));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            min = Math.max(min, (nums[i] + nums[n-i-1]));
        }
        return min;
    }
}
