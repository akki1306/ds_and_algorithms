package sortingsearching;

import java.util.Arrays;

/**
 * You are given MXN matrix which is row wise and column wise sorted. You have to search the index of given integer K in
 * the matrix.
 *
 * Input format:
 *
 * Function containing integer M, integer N, 2D vector containing integers and an integer k.
 *
 * Output format:
 *
 * Return a pair of integers {x,y} where x is the row index and y is the column index of k in the matrix.
 *
 * Expected complexity:
 *
 * Linear
 *
 * Output
 *
 * {1,2}
 */
public class StaircaseSearch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(staircaseSearch(new int[][]{{1, 4, 9}, {2, 5, 10}, {6, 7, 11}}, 10)));
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
