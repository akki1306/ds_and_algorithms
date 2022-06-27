package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate all possible n pairs
 * of balanced parentheses '(' and ')'
 */
public class GeneratingBrackets {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        generateBrackets(res, "", 10, 0, 0);
        System.out.println(res);
    }

    private static void generateBrackets(List<String> result, String currentString, int N, int openCount, int closedCount) {
        if ((openCount + closedCount) == N && openCount == closedCount)
            result.add(currentString);

        if (openCount < N)
            generateBrackets(result, currentString + "(", N, openCount + 1, closedCount);

        if (openCount > closedCount)
            generateBrackets(result, currentString + ")", N, openCount, closedCount + 1);
    }
}
