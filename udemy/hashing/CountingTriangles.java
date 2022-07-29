package udemy.hashing;

import udemy.hashing.ds.Point;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given N Cartesian points in a 2D plane, find the number of
 * triangles such that the base or perpendicular is parallel
 * to the X-axis or Y-axis. Right angled triangle.
 * <p>
 * Sample Input:
 * N=3
 * (0,0)(2,0)(0,1)
 * <p>
 * Sample Output:
 * 1
 */
public class CountingTriangles {
    public static void main(String[] args) {
       /* System.out.println(countTriangles(Arrays.asList(
                new Point(0,0),
                new Point(2,0),
                new Point(0,1)
        )));*/

        System.out.println(countTriangles(Arrays.asList(
                new Point(1, 2),
                new Point(2, 0),
                new Point(2, 2),
                new Point(2, 3),
                new Point(4, 2)
        )));
    }

    private static int countTriangles(List<Point> points) {
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        //1. insert points into map
        for (Point p : points) {
            xMap.put(p.x, xMap.getOrDefault(p.x, 0) + 1);
            yMap.put(p.y, yMap.getOrDefault(p.y, 0) + 1);
        }

        int ans = 0;
        //2. find two points and lookup the third one
        for (Point p : points) {
            int x = p.x;
            int y = p.y;
            int fx = xMap.get(x);
            int fy = yMap.get(y);

            ans += (fx - 1) * (fy - 1);
        }
        return ans;
    }
}
