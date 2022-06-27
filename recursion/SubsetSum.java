package recursion;

/**
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum
 * equal to given sum.
 * <p>
 * Input:
 * <p>
 * arr=[10,12,15,6,19,20]
 * <p>
 * sum=16
 */
public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(subsetSumRecursive(new int[]{1, 2, 3, 4, 5}, 0, 10));
    }

    private static int subsetSumRecursive(int[] arr, int index, int target) {
        if (index == arr.length) {
            if (target == 0)
                return 1;
            return 0;
        }

        return subsetSumRecursive(arr, index + 1, target - arr[index]) +
                subsetSumRecursive(arr, index + 1, target);
    }
}
