package binarysearch;

import java.util.Arrays;

/**
 * Angry Birds
 *
 * There is a long wire along at straight line, which contains N bird nests
 * at position x1, x2,...,xN.
 *
 * There are B(B<=N) birds, which become angry towards each other once put into
 * a nest. To put the birds from hurting each other you want to assign birds to nests
 * such that minimum distance between any two birds is as large as possible. What is
 * the largest minimum distance?
 *
 * Sample Input:
 *
 */
public class AngryBirds {
    public static void main(String[] args) {
        System.out.println(angryBirdsMinimizeMaximumDistanceToNotLetBirdsAngry(new int[]{1, 2, 4, 8, 9}, 3));
    }

    // maximize minimum distance between two birds
    private static int angryBirdsMinimizeMaximumDistanceToNotLetBirdsAngry(int[] arr, int numberOfBirds) {
        Arrays.sort(arr);
        int N = arr.length;
        int start = 0;
        int end = arr[N - 1] - arr[0]; // Search space is the distance between two birds
        int mid;
        int ans = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (canPlaceBirds(arr, numberOfBirds, mid)) {
                ans = mid;
                start = mid + 1; // maximize the distance if can place birds.
            } else {
                end = mid - 1; // if placing all birds not possible then go left.
            }
        }
        return ans;
    }

    private static boolean canPlaceBirds(int[] arr, int numberOfBirds, int minSeperation) {

        int birds = 1;
        int location = arr[0];

        for (int i = 1; i < arr.length; i++) {
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
