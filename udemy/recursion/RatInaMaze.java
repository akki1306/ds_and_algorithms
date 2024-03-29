package udemy.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a an integer N and a grid of size NxN. The cells of the grid are numbered row wise
 * from 1 to N^2. Rat wants to travel from cell number 1 to cell number N^2, and it can move only in
 * right direction or down direction from particular cell. There is exactly one path from source
 * to destination as come cells are blocked. Help the rat to find the path.
 *
 * Input Format:
 *
 * In the function an integer N is given and a 2D vector consisting of only 'O's and 'X's is given
 * where 'X' represent blocked cell.
 *
 * Output Format:
 *
 * Return a vector of cell numbers of cells in path(in sequence)
 */
public class RatInaMaze {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 0}
        };
        List<Integer> res = new ArrayList<>();
        res.add(1);
        System.out.println(ratPath(arr, 0, 0, res));
        System.out.println(res);
    }

    private static boolean ratPath(int[][] maze, int i, int j, List<Integer> res) {
        if (i == maze.length && j == maze.length) {
            return true;
        }

        if (i >= maze.length || j >= maze.length)
            return false;

        if (maze[i][j] == 1)
            return false;
        else {
            res.add(maze.length * i + j + 1);
            boolean isPossible = ratPath(maze, i + 1, j, res) || ratPath(maze, i, j + 1, res);
            if (!isPossible)
                res.remove(maze[i][j]);
        }

        return true;
    }
}
