package recursion;

/**
 * Given a ladder containing N steps, you can take a
 * jump of 1, 2 or 3 at each step. Find the number of
 * ways to climb the ladder.
 */
public class Ladders {
    public static void main(String[] args) {
        System.out.println(laddersNumberOfWaysToClimb(5));
    }

    // time complexity - exponential O(3^n)
    private static int laddersNumberOfWaysToClimb(int N) {
        if (N == 0)
            return 1;
        if (N < 0)
            return 0;

        return laddersNumberOfWaysToClimb(N - 1) +
                laddersNumberOfWaysToClimb(N - 2) + laddersNumberOfWaysToClimb(N - 3);
    }
}
