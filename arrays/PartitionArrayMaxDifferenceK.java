package arrays;

import java.util.Arrays;

// Leetcode 2294
public class PartitionArrayMaxDifferenceK {
    public static void main(String[] args) {
//        System.out.println(partitionArrayMaxDifferenceK(new int[]{1,5}, 1));
        System.out.println(partitionArrayMaxDifferenceKLinear(new int[]{3, 6, 1, 2, 5}, 2));
    }

    // time complexity - O(NLogN)
    private static int partitionArrayMaxDifferenceK(int nums[], int k) {
        int n = nums.length;

        if (n == 1)
            return 1;

        Arrays.sort(nums);
        int i = 1;
        int sequence = 0;
        int min = nums[0];
        while (i < n) {
            if ((nums[i] - min) <= k) {
                i++;
            } else {
                sequence++;
                min = nums[i];
            }
        }
        if ((nums[n - 1] - min) <= k)
            sequence++;

        return sequence;
    }

    // time complexity - O(N)
    private static int partitionArrayMaxDifferenceKLinear(int[] nums, int k) {
        int[] buckets = new int[100001];
        int max = 0;
        for (int num : nums) {
            buckets[num]++;
            max = Math.max(max, num);
        }
        int result = 0;
        for (int i = 0; i <= max; i++) {
            if (buckets[i] > 0) {
                result++;
                i += k;
            }
        }
        return result;
    }
}
