package recursion;

import java.util.ArrayList;
import java.util.List;

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

        if(i>=maze.length || j>=maze.length)
            return false;

        if (maze[i][j] == 1)
            return false;
        else {
            res.add(maze.length*i + j + 1);
            boolean isPossible = ratPath(maze, i + 1, j, res) || ratPath(maze, i, j + 1, res);
            if (!isPossible)
                res.remove(maze[i][j]);
        }

        return true;
    }
}
