package recursion;

import java.util.Arrays;

/**
 * Sudoku Solver
 *
 * Given a partially filled matrix Sudoku Matrix of 9x9,
 * write a function to fill the matrix using Sudoku rules.
 *
 * Input:
 * 2D Matrix
 *
 * Output:
 * Solved 2D Matrix
 */
public class SudokuSolver {
    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 0}
        };
        System.out.println(sudokuSolver(grid, 0, 0));

        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    private static boolean sudokuSolver(int[][] grid, int r, int c) {
        // base case
        if (r == grid.length)
            return true;

        //rec case

        if (c == grid.length)
            return sudokuSolver(grid, r + 1, 0);

        if (grid[r][c] != 0)
            return sudokuSolver(grid, r, c + 1);

        for (int i = 1; i < 10; i++) {
            if (canPutNumber(grid, r, c, i)) {
                grid[r][c] = i;
                boolean canSolveRemainingGrid = sudokuSolver(grid, r, c + 1);
                if (canSolveRemainingGrid) {
                    return true;
                }
            }
        }
        grid[r][c] = 0;
        return false;
    }

    private static boolean canPutNumber(int[][] grid, int row, int col, int i) {
        // check if number exists in row or col
        for (int r = 0; r < grid.length; r++) {
            if (grid[r][col] == i || grid[row][r] == i)
                return false;
        }

        int sx = (row / 3) * 3;
        int sy = (col / 3) * 3;

        // check if number exists in grid
        for (int j = sx; j < sx + 3; j++) {
            for (int k = sy; k < sy + 3; k++) {
                if (grid[j][k] == i)
                    return false;
            }
        }
        return true;
    }
}
