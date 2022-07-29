package udemy.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a udemy.string s, find all permutations of a given udemy.string.
 *
 * Input:
 *
 * abc
 *
 * Output:
 *
 * abc, acb, bac, bca, cab, cba
 */
public class Permutations {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        String s = "abc";
        boolean[] isUsed = new boolean[s.length()];
        permutations(res, s.toCharArray(), "", isUsed);
        System.out.println(res);
    }

    private static void permutations(List<String> res, char[] arr, String output, boolean[] isUsed) {
        if (output.length() == arr.length) {
            res.add(output);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!isUsed[i]) {
                output += arr[i];
                isUsed[i] = true;
                permutations(res, arr, output, isUsed);
                output = output.substring(0, output.length() - 1);
                isUsed[i] = false;
            }
        }
    }
}
