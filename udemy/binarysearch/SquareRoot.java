package udemy.binarysearch;

import java.text.DecimalFormat;

/**
 * Square roots
 *
 * Given an integer N and an integer P, you need to find the square root of
 * number N upto P places. Do it without using a library function.
 *
 * Input Array:
 * N=10, P=3
 *
 * Output: 3.162
 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(10, 3));
    }

    private static double squareRoot(int num, int precision) {
        int s = 0;
        int e = num;
        int mid = -1;
        int ans = 0;

        // binary search for integer part
        while (s <= e) {
            mid = (s + e) / 2;
            if (mid * mid == num) {
                return mid;
            } else if (mid * mid > num) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }

        // linear search for decimal places
        int i = 1;
        double res = ans;
        double inc = 0.1f;
        DecimalFormat df = new DecimalFormat("#.###");
        while (i <= precision) {
            while ((res * res) <= num) {
                res = res + inc;
            }
            res = res - inc;
            i++;
            inc = (inc / 10.0);
        }
        return Double.valueOf(df.format(res));
    }
}
