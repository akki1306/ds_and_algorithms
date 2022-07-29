package udemy.binarysearch;

import java.util.Arrays;

/**
 *  Game of Greed
 *
 *  You are playing a game with your 'k' friends. You have an array of N coins, at each index i you have a coin of
 *  value a[i]. Your task is to divide the coins, amoung a group of K friends by doing consecutive segments (k-subarray)
 *  of the array. Each friend will get a total sum of coins in that subarray. Since all your friends are greedy and they
 *  will pick the largest k-1 segments and you will get the smallest segment. Find out the maximum value you can make by
 *  making an optimal partition.
 *
 *  Note: The coin array may or may not be sorted
 *
 *  Input:
 *
 *  K = 3
 *  coins={1,2,3,4}
 */
public class GameOfGreed {
    public static void main(String[] args) {
        System.out.println(gameOfGreedMaximizeMinimum(new int[]{1, 2, 3, 4}, 3));
    }

    // maximize minimum number of coins
    private static int gameOfGreedMaximizeMinimum(int[] arr, int k) {
        Arrays.sort(arr);
        int s = arr[0];
        int e = Arrays.stream(arr).sum();
        int mid;
        int res = Integer.MAX_VALUE;
        while (s <= e) {
            mid = (s + e) / 2;
            if (canAllocateCoins(arr, k, mid)) {
                res = mid;
                s = mid + 1; // since the goal is to maximize hence expand search on the right side to find maximum
            } else {
                e = mid - 1; // search towards left only if allocation not possible
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
