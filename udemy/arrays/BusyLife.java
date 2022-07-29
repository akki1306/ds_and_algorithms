package udemy.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Activity scheduling problem
 */
public class BusyLife {
    public static void main(String[] args) {
        Pair[] arr = new Pair[]{new Pair(1, 5), new Pair(1, 7), new Pair(2, 5), new Pair(6, 9), new Pair(8, 12), new Pair(9, 12)};
        System.out.println(countActivities(arr));
    }

    private static int countActivities(Pair[] v) {
        Arrays.sort(v, new PairComparator());
        int finish = v[0].endTime;
        int count = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i].startTime >= finish) {
                count++;
                finish = v[i].startTime;
            }
        }
        return count;
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o1.endTime, o2.endTime);
        }
    }

    static class Pair {
        int startTime;
        int endTime;

        Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
