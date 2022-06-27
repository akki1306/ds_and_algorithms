package recursion;

public class NQueens {
    public static void main(String[] args) {
        int N = 4;
        int[][] cb = new int[N][N];
        for (int i = 0; i < cb.length; i++) {
            for (int j = 0; j < cb[0].length; j++) {
                cb[i][j] = 0;
            }
        }
        if(nQueens(cb, 0)){
            for (int i = 0; i < cb.length; i++) {
                for (int j = 0; j < cb[0].length; j++) {
                    System.out.print(cb[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean nQueens(int[][] cb, int row) {
        if (row == cb.length)
            return true;

        for (int c = 0; c < cb.length; c++) {
            if (canPlace(cb, row, c)) {
                cb[row][c] = 1;
                boolean success = nQueens(cb, row + 1);
                if (success)
                    return true;
                cb[row][c] = 0;
            }
        }
        return false;
    }

    private static boolean canPlace(int[][] cb, int row, int col) {
        for (int k = 0; k < row; k++) {
            if (cb[k][col] == 1)
                return false;
        }

        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (cb[i][j] == 1)
                return false;

            i--;
            j--;
        }

        i = row;
        j = col;
        while (i >= 0 && j < cb.length) {
            if (cb[i][j] == 1)
                return false;
            i--;
            j++;
        }
        return true;
    }
}
