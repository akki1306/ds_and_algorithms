package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps {
    public static void main(String[] args) {
        System.out.println(minimumNumberOfSwapsToSort(new int[]{2, 4, 5, 1, 3}));
    }

    // time complexity - O(NLogN)
    // space complexity - O(N)
    private static int minimumNumberOfSwapsToSort(int[] arr) {
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        Arrays.sort(arr);

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (visited[i] || i == map.get(arr[i]))
                continue;

            int node = i;
            int cycle = 0;

            while (!visited[node]) {
                visited[node] = true;
                node = map.get(arr[node]);
                cycle++;
            }

            ans += (cycle - 1);
        }
        return ans;
    }
}
