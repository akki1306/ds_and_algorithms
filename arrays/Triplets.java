package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Triplets to target sum
 * <p>
 * Use of optimal space and time complexity
 */
public class Triplets {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 15);
        int targetSum = 18;

        System.out.println(findTripletsToTargetSumOptimalSpaceTime(input, targetSum));
    }

    /**
     * Time complexity - O(NLogN) + O(N2) which equates to O(N2)
     * <p>
     * Space complexity - O(1)
     */
    private static List<List<Integer>> findTripletsToTargetSumOptimalSpaceTime(List<Integer> input, Integer targetSum) {
        Collections.sort(input);
        List<List<Integer>> res = new ArrayList<>();
        int n = input.size();
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int first = input.get(i);
                int second = input.get(j);
                int third = input.get(k);
                int currentSum = first;
                currentSum+= second;
                currentSum+= third;
                if (targetSum == currentSum) {
                    res.add(Arrays.asList(first, second, third));
                    j++;
                    k--;
                } else if (targetSum > currentSum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
