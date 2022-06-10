package arrays;

import java.util.Arrays;

public class MinimumDifference {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minimumDifference(new int[]{23, 5, 10, 17, 30}, new int[]{26, 134, 135, 14, 19})));
    }

    private static int[] minimumDifference(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int m = arr1.length;
        int n = arr2.length;


        int len = Math.min(m, n);

        int i = 0, j = 0;
        int minDifference = Integer.MAX_VALUE;
        int[] res = new int[2];
        while (i < len && j < len) {
            if (Math.abs(arr1[i] - arr2[j]) < minDifference) {
                res[0] = arr1[i];
                res[1] = arr2[j];
            }
            minDifference = Math.min(minDifference, Math.abs(arr1[i] - arr2[j]));
            if (arr1[i] < arr2[j])
                i++;
            else
                j++;
        }
        return res;
    }
}