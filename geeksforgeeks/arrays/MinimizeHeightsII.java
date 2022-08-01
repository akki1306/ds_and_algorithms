package geeksforgeeks.arrays;

import java.util.Arrays;

public class MinimizeHeightsII {
    public static void main(String[] args) {
        System.out.println(getMinDiff(new int[]{7,4,8,8,8,9},6,6));
    }

    static int getMinDiff(int[] arr, int n, int k) {
        int max;
        int min;
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        for(int i=1;i<n;i++){
            if (arr[i] - k < 0)
                continue;
            min = Math.min(arr[0]+k, arr[i]-k);
            max = Math.max(arr[i-1]+k, arr[n-1]-k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
