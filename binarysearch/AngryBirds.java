package binarysearch;

import java.util.Arrays;

public class AngryBirds {
    public static void main(String[] args) {
        System.out.println(angryBirdsMinimizeMaximumDistanceToNotLetBirdsAngry(new int[]{1, 2, 4, 8, 9}, 3));
    }

    private static int angryBirdsMinimizeMaximumDistanceToNotLetBirdsAngry(int[] arr, int numberOfBirds) {
        Arrays.sort(arr);
        int N = arr.length;
        int start = 0;
        int end = arr[N - 1] - arr[0];
        int mid;
        int ans = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (canPlaceBirds(arr, numberOfBirds, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canPlaceBirds(int[] arr, int numberOfBirds, int minSeperation) {

        int birds = 1;
        int location = arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            int current_location = arr[i];
            if ((current_location - location) >= minSeperation) {
                birds++;
                location = current_location;
            }
            if (birds == numberOfBirds)
                return true;

        }
        return false;
    }
}
