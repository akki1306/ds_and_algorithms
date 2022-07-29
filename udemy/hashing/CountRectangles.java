package udemy.hashing;

import udemy.hashing.ds.Point;
import udemy.hashing.ds.PointComparator;

import java.util.*;

/**
 * Counting Rectangles
 *
 * Given N Cartesian Points in a 2D plane, find the number of axis parallel rectangles
 * that can be formed?
 *
 * Sample Input:
 *
 * N = 8
 * [(0,0),(0,1),(1,1),(1,0),(2,1),(2,0),(3,1),(3,0)]
 *
 * Output:
 *
 * 6
 */
public class CountRectangles {
    public static void main(String[] args) {
        System.out.println(countRectangles(Arrays.asList(
                new Point(4, 1),
                new Point(4, 0),
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(1, 0),
                new Point(2, 0),
                new Point(2, 1))));
    }

    private static int countRectangles(List<Point> points) {
        // 1. insert all points in the set.
        Map<Point, Boolean> set = new TreeMap<>(new PointComparator());
        for (Point p : points) {
            set.put(p, true);
        }

        // 2. Brute force logic for two points. For other two lookup
        int ans = 0;
        for (int i = 0; i <= points.size() - 1; i++) {
            for (int j = i + 1; j <= points.size() - 1; j++) {
                Point p1 = points.get(i);
                Point p2 = points.get(j);

                // small check that we need to make
                if (p2.x == p1.x || p2.y == p1.y)
                    continue;

                // P3, P4
                Point p3 = new Point(p2.x, p1.y);
                Point p4 = new Point(p1.x, p2.y);

                if (set.containsKey(p3) && set.containsKey(p4))
                    ans += 1;

            }
        }
        return ans / 2;
    }




}
