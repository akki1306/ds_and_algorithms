package hashing;

import hashing.ds.Point;
import hashing.ds.PointComparator;

import java.security.cert.PolicyNode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
                new Point(1,2),
                new Point(2,0),
                new Point(2,2),
                new Point(2,3),
                new Point(4,2)
        )));
    }

    private static int countTriangles(List<Point> points) {
        Map<Point, Boolean> map = new TreeMap(new PointComparator());

        //1. insert points into map
        for (Point p : points)
            map.put(p, true);

        int ans = 0;
        //2. find two points and lookup the third one
        for (int i = 0; i <= points.size() - 1; i++) {
            for (int j = 0; j <= points.size() - 1; j++) {
                Point p1 = points.get(i);
                Point p2 = points.get(j);

                if (p1.x == p2.x || p1.y == p2.y)
                    continue;

                Point p3 = new Point(p2.x, p1.y);
                if (map.containsKey(p3))
                    ans += 1;
            }
        }
        return ans;
    }
}
