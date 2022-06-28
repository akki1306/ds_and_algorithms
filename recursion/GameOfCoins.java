package recursion;

/**
 * Oxford and Henry are playing the game of coins. The have a row of 'n' coins [C1,C2,C3...Cn] with values [V1,V2,V3...Vn]
 * Where Ci coin has Vi value. They take turns alternatively. In one turn the player can pick either the first or the last
 * coin of the row. Given both Oswald and Henry are very smart players, you need to find the maximum possible value
 * Oswald can earn if he plays first.
 * <p>
 * Input:
 * <p>
 * array of coins which represent value of each coin at that position
 * <p>
 * Output:
 * <p>
 * Return a single integer which is the maximum possible value as asked in the question
 * <p>
 * Constraints:
 * 1<=N<=15
 */
public class GameOfCoins {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(gameOfCoins(arr, 0, arr.length - 1));
    }

    private static int gameOfCoins(int[] arr, int i, int j) {
        if (i >= arr.length || j <= -1 || i > j)
            return 0;

        // recurrence relation
        int option1 = arr[i] + Math.min(gameOfCoins(arr, i + 2, j), gameOfCoins(arr, i + 1, j - 1));
        int option2 = arr[j] + Math.min(gameOfCoins(arr, i + 1, j - 1), gameOfCoins(arr, i, j - 2));
        return Math.max(option1, option2);
    }
}
