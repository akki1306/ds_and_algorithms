package binarysearch;

import java.util.Arrays;

public class GameOfGreed {
    public static void main(String[] args) {
        System.out.println(gameOfGreed(new int[]{1, 2, 3, 4}, 3));
    }

    // maximize minimum number of coins
    private static int gameOfGreed(int[] arr, int k) {
        Arrays.sort(arr);
        int s = arr[0];
        int e = Arrays.stream(arr).sum();
        int mid;
        int res = Integer.MAX_VALUE;
        while (s <= e) {
            mid = (s + e) / 2;
            if (canAllocateCoins(arr, k, mid)) {
                res = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return res;
    }

    private static boolean canAllocateCoins(int[] arr, int k, int minCoins) {
        int friends = 0;
        int current_friend = 0;
        for (int i = 0; i < arr.length; i++) {
            if (current_friend + arr[i] >= minCoins) {
                friends++;
                current_friend = 0;
            } else {
                current_friend += arr[i];
            }
        }
        return friends == k;
    }
}
