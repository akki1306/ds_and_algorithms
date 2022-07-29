package udemy.recursion;

/**
 * You are given two numbers a and b, your task is to compute a raised to the power of b.
 *
 * As this value can be very large compute it to modulo 1000000007
 *
 * Hint: Use modulo properties
 * (m*n)%p has a very interesting property
 * (m*n)%p = ((m%p) * (n%p)) % p
 *
 * Expected Time complexity:
 *
 * O(log b)
 *
 * Input Format:
 *
 * In the function 2 integers a and b are passed.
 *
 * Output Format:
 *
 * Return a single integer which is equivalent to (a^b) modulo 1000000007
 *
 * Constraints:
 *
 * 1<=a, b<=50
 *
 * Sample Testcase:
 *
 * Input:
 *
 * 5 3
 *
 * Output:
 *
 * 125
 */
public class ModuloExponentiation {
    public static void main(String[] args) {
        System.out.println(moduloExponentiation(5, 1000, (long) (1e9+7)));
    }

    private static long moduloExponentiation(int a, int b, long C) {
        if (a == 0) return 0;
        if (b == 0) return 1;

        long y;
        if (b % 2 != 0) {
            y = ((a % C) * (moduloExponentiation(a, b - 1, C) % C)) % C;
        } else {
            y = (moduloExponentiation(a, b / 2, C));
            y = (y * y) % C;
        }
        return y;
    }
}
