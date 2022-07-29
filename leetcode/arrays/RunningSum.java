package leetcode.arrays;

import java.util.Arrays;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 */
public class RunningSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1,2,3,4})));
    }

    public static int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++)
            nums[i] += nums[i-1];

        return nums;
    }
}
