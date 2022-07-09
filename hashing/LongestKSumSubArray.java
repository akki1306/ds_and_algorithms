package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestKSumSubArray {
    public static void main(String[] args) {
        System.out.println(longestKSumSubArray(new int[]{0, -2, 1, 2, 3, 4, 5, 15, 10, 5}, 15));
        System.out.println(longestKSumSubArrayPositiveNumbers(new int[]{1, 2, 3, 4, 5, 15, 10, 5}, 15));
    }

    private static int longestKSumSubArray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k)
                maxLen = Math.max(i + 1, maxLen);

            if(!map.containsKey(sum))
                map.put(sum, i);

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }
        return maxLen;
    }



    private static int longestKSumSubArrayPositiveNumbers(int[] arr, int k) {
        int i = 0, j = 1, sum = arr[0];
        int max = Integer.MIN_VALUE;
        while (j < arr.length) {
            sum += arr[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (sum > k) {
                    sum -= arr[i];
                    i++;
                }
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
                j++;
            }
        }
        return max;
    }
}
