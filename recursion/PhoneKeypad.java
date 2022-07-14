package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number N and a modern phone keypad. Find out all possible strings
 * generated using that number.
 *
 * Sample Input:
 *
 * 23
 *
 * Sample Output:
 *
 * AD, AE, AF, BD, BE, BF, CD, CE, CF
 */
public class PhoneKeypad {
    static String[] keypad = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        printKeypadOutput(res, "234", "", 0);
        System.out.println(res);
    }

    private static void printKeypadOutput(List<String> res, String input, String output, int i) {
        if (i == input.length()) {
            res.add(output);
            return;
        }

        int current_digit = input.charAt(i) - '0';
        if (current_digit == 0 || current_digit == 1) {
            printKeypadOutput(res, input, output, i + 1);
        }

        for (int k = 0; k < keypad[current_digit].length(); k++) {
            printKeypadOutput(res, input, output + keypad[current_digit].charAt(k), i + 1);
        }
        return;
    }
}
