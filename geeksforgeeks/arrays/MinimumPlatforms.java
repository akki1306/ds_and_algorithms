package geeksforgeeks.arrays;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        System.out.println(findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800},new int[]{910, 1200, 1120, 1130, 1900, 2000}, 6));
    }

    static int findPlatform(int arr[], int dep[], int n) {
        return findPlatformHelper(arr, dep, n);
    }

    private static int findPlatformHelper(int[] arr, int[] dep, int n) {
        Arrays.sort(dep);
        Arrays.sort(arr);
        int platform = 1;
        int max = Integer.MIN_VALUE;
        int i = 0, j = 1;
        while (i < n && j < n) {
            if (arr[j] <= dep[i]) {
                platform++;
                j++;
            } else if (arr[j] > dep[i]) {
                platform--;
                i++;
            }
            max = Math.max(max, platform);
        }

        return max;
    }

}
