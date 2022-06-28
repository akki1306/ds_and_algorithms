package recursion;

public class GameOfCoins {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(gameOfCoins(arr, 0, 0, arr.length - 1));
    }

    private static int gameOfCoins(int[] arr, int round, int i, int j) {
        if (i == j)
            if (round % 2 == 0)
                return arr[i];
            else
                return 0;

        boolean isGreater = arr[i] > arr[j];
        int val = Math.max(arr[i], arr[j]);

        if (isGreater)
            i++;
        else
            j--;

        int nextRoundVal = gameOfCoins(arr, round + 1, i, j);

        if (round % 2 == 0)
            return val + nextRoundVal;
        else
            return nextRoundVal;
    }
}
