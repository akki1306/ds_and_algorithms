package udemy.arrays;

// Leetcode 134
public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, surplus = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }
        return sum >= 0 ? start : -1;
    }
}
