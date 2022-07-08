package hashing;

import java.util.*;

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
        for (int i = 0; i <= points.size() - 2; i++) {
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

    static class Point {
        public int x;
        public int y;


        public Point() {

        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point that = (Point) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            if (o1.x == o2.x)
                return Integer.compare(o1.y, o2.y);
            return Integer.compare(o1.x, o2.x);
        }
    }
}
