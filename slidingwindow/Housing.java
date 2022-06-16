package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Housing {
    public static void main(String[] args) {
        //  System.out.println(continuousPlotsWithSizeK(new int[]{1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2}, 8));
        //System.out.println(continuousPlotsWithSizeKSlidingWindow(new int[]{1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2}, 8));
        int[] res = continuousPlotsWithSizeKSmallestWindow(new int[]{1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2}, 8);
        System.out.println(res[0] + "," + res[1]);

    }

    // time complexity - O(NLogN)
    // space complexity - O(N)
    // using prefix sum
    private static List<List<Integer>> continuousPlotsWithSizeK(int[] nums, int K) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(prefixSum, K + prefixSum[i]);
            if (index > 0 && index != i) {
                result.add(Arrays.asList(i + 1, index));
            }
        }
        return result;
    }

    // time complexity - O(N)
    // space complexity - O(1)
    private static List<List<Integer>> continuousPlotsWithSizeKSlidingWindow(int[] nums, int K) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int i = 0, j = 0;
        int windowSum = 0;
        while (j < n && i <= j) {
            if (windowSum <= K) {
                if (windowSum == K)
                    result.add(Arrays.asList(i, j - 1));
                windowSum += nums[j++];
            } else {
                windowSum -= nums[i++];
            }
        }
        return result;
    }

    private static int[] continuousPlotsWithSizeKSmallestWindow(int[] nums, int K) {
        int n = nums.length;
        int i = 0, j = 0;
        int windowSum = 0;
        int[] res = new int[2];
        int minWindowSize = Integer.MAX_VALUE;
        while (j < n && i <= j) {
            if (windowSum <= K) {
                if (windowSum == K && Math.min(j - i, minWindowSize) == j - i) {
                    res[0] = i;
                    res[1] = j - 1;
                    minWindowSize = j - i;
                }
                windowSum += nums[j++];
            } else {
                windowSum -= nums[i++];
            }
        }
        return res;
    }
}