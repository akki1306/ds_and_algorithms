package leetcode.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch(nums,0, nums.length, 0));
    }

    private static int binarySearch(int[] nums, int s, int e, int t) {
        if (s > e)
            return -1;

        int mid = (s + e) / 2;
        if (t == nums[mid])
            return mid;
        else if (t < nums[mid])
            return binarySearch(nums, s, mid - 1, t);
        else
            return binarySearch(nums, mid + 1, e, t);
    }
}
