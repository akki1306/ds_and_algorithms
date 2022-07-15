package priorityqueue;

import java.util.*;

/**
 * Finding cabs
 *
 * Given N Cartesian points in a 2D plane each represents the location of the cab.
 * You are standing at the origin, you want to know the names of the nearest cab.
 *
 * Sample Input             Output
 * N = 5, K = 3             C4
 * C1 1 1                   C1
 * C2 2 1                   C2
 * C3 3 2
 * C4 0 1
 * C5 2 3
 */
public class FindingCabs {
    public static void main(String[] args) {
        Car C1 = new Car("C1", 1, 1);
        Car C2 = new Car("C2", 2, 1);
        Car C3 = new Car("C3", 3, 2);
        Car C4 = new Car("C4", 0, 1);
        Car C5 = new Car("C5", 2, 3);

        System.out.println(nearestCar(Arrays.asList(C1, C2, C3, C4, C5), 3));
    }

    private static List<Car> nearestCar(List<Car> cars, int k) {
        PriorityQueue<Car> queue = new PriorityQueue<>(new CarComparator());
        List<Car> result = new ArrayList<>();

        //first k elements
        int i=0;
        for (i = 0; i < k; i++) {
            queue.add(cars.get(i));
        }

        // remaining elements from k to n
        int n = cars.size();
        for (; i < n; i++) {
            if (cars.get(i).dist() < queue.peek().dist()) {
                queue.poll();
                queue.add(cars.get(i));
            }
        }

        // all elements present in the max heap are nearest cars to the origin point 0,0
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        Collections.reverse(result);

        return result;
    }

    static class CarComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o2.dist().compareTo(o1.dist()); // max heap
        }
    }

    static class Car {
        String name;
        int x;
        int y;

        Car(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        Integer dist() {
            return x*x + y*y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return x == car.x && y == car.y && Objects.equals(name, car.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, x, y);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
