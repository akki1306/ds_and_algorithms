package recursion;

public class GameOfCoinsAdvanced {
    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 9, 2, 5};
        System.out.println(gameOfCoins(arr, 0, arr.length - 1, 2));
    }

    static int sum(int[] v, int i, int j) {
        int res = 0;
        for (int k = i; k < j; k++) res += v[k];
        return res;
    }

    // Do your best and expect the worst
    static int gameOfCoins(int[] v, int s, int e, int totalChances) {
        if (e - s + 1 < 0) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        for (int fpi = 0; fpi <= totalChances; fpi++) {
            int ans = sum(v, s, s + fpi) + sum(v, e - totalChances + fpi + 1, e + 1);
            int op = Integer.MAX_VALUE;
            for (int spi = 0; spi <= totalChances; spi++) {
                // e - ((totalChances - fpi) + (totalChances - spi)))
                op = Math.min(op, gameOfCoins(v, s + fpi + spi, e - totalChances + fpi - totalChances + spi, totalChances));
            }
            res = Math.max(res, ans + op);
        }

        return res;
    }

}
