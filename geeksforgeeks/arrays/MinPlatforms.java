package geeksforgeeks.arrays;

import java.util.Arrays;

public class MinPlatforms {
    public static void main(String[] args) {
//        System.out.println(findPlatformHelper(new int[]{0_900, 0_940},null,1));
    }

    private static int findPlatformHelper(int[] arr, int[] dep, int n){
        Arrays.sort(dep);
        Arrays.sort(arr);
        int platform = 1;
        int max = Integer.MIN_VALUE;
        int i=0, j=1;
        while(i<n && j<n){
            if(arr[j] <= dep[i]){
                platform++;
                j++;
            }else if(arr[j] > dep[i]){
                platform--;
                i++;
            }
            max = Math.max(max, platform);
        }

        return max;
    }
}
