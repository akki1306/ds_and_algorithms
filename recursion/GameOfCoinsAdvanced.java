package recursion;

public class GameOfCoinsAdvanced {
    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 9, 2, 5};
        System.out.println(gameOfCoins(arr, 0, 0, arr.length - 1, 2));
    }

    private static int gameOfCoins(int[] arr, int round, int i, int j, int k) {
        if (i > j)
            return 0;

        if (i == j)
            return round % 2 == 0 ? arr[i] : 0;


        int n = i;
        int m = j;
        int val = 0;
        int count = 0;

        while (n < arr.length && m >= 0 && count++ < k && n <= m) {
            if (arr[n] > arr[m]) {
                if (round % 2 == 0)
                    val += arr[n];
                n++;
            } else {
                if (round % 2 == 0)
                    val += arr[m];
                m--;
            }
        }
        return (round % 2 == 0 ? val : 0) + gameOfCoins(arr, round + 1, Math.min(arr.length - 1, n), Math.max(0, m), k);
    }

}
