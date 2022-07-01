package priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        System.out.println(mergeKArrays(new int[][]{{1, 3, 15}, {12, 13, 14, 16}, {0, 9, 10, 11}}, 3));
    }

    private static List<Integer> mergeKArrays(int[][] kArr, int k) {
        PriorityQueue<HeapElement> queue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        int[] counter = new int[k];

        for (int i = 0; i < counter.length; i++) {
            counter[i] = 0;
            queue.add(new HeapElement(kArr[i][0], i));
        }

        while (!isReachedLastIndex(counter, kArr)) {
            HeapElement e = queue.poll();
            result.add(e.val);
            counter[e.arrIndx]++;
            if (counter[e.arrIndx] < kArr[e.arrIndx].length)
                queue.add(new HeapElement(kArr[e.arrIndx][counter[e.arrIndx]], e.arrIndx));
        }
        return result;
    }

    private static boolean isReachedLastIndex(int[] counter, int[][] kArr) {
        boolean ret = true;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] < kArr[i].length) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    static class HeapElement implements Comparable<HeapElement> {
        Integer val;
        int arrIndx;

        HeapElement(Integer val, int arrIndx) {
            this.val = val;
            this.arrIndx = arrIndx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HeapElement that = (HeapElement) o;
            return val == that.val && arrIndx == that.arrIndx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, arrIndx);
        }

        @Override
        public int compareTo(HeapElement o) {
            return this.val.compareTo(o.val);
        }
    }
}
