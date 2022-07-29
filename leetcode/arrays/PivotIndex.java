package leetcode.arrays;

public class PivotIndex {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1,-1,0,0,-1,-1}));
    }

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int n = nums.length;

        for (int i : nums)
            rightSum += i;

        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
