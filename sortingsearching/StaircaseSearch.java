package sortingsearching;

import java.util.Arrays;

public class StaircaseSearch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(staircaseSearch(new int[][]{{1, 4, 9}, {2, 5, 10}, {6, 7, 11}}, -1)));
    }

    private static int[] staircaseSearch(int[][] matrix, int toSearch) {
        int M = matrix.length;
        int N = matrix[0].length;
        int i = 0;
        int j = N - 1;
        int resX = -1;
        int resY = -1;

        while (i < M && j >= 0) {
            if (toSearch == matrix[i][j]) {
                resX = i;
                resY = j;
                break;
            } else if (toSearch > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{resX, resY};
    }
}
