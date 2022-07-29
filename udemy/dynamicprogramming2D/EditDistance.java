package udemy.dynamicprogramming2D;

/**
 * Edit distance
 *
 * Given two strings str1 and str2 and below operations that can be performed on str1. Find minimum
 * number of edits (operations) required to convert 'str1' into 'str2'
 *
 * Insert
 *
 * Remove
 *
 * Replace
 *
 * All of the above operations are of equal cost
 *
 * Input Format:
 *
 * Function containing two strings str1 and str2 as parameters.
 *
 * Output Format:
 *
 * Return a single integer representing minimum number of operations required to convert
 * str1 to str2.
 *
 * Constraints:
 *
 * 1 <= str1.length() <= 100
 * 1 <= str2.length() <= 100
 *
 * Sample Testcases:
 *
 * Input:
 *
 * str1 = "geek"
 * str2 = "gesek"
 *
 * Output: 1
 *
 * We can convert str1 to str2 by inserting a 's'.
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minimumEdits("geek", "gessek", 0, 0));
    }

    private static int minimumEdits(String s1, String s2, int i, int j) {
        if (i >= s1.length() && j < s2.length())
            return s2.length() - j;

        if (j >= s2.length() && i < s1.length())
            return s1.length() - i;

        if (i >= s1.length() && j >= s2.length())
            return 0;

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if (c1 == c2)
            return minimumEdits(s1, s2, i + 1, j + 1);

        int remove = minimumEdits(s1, s2, i + 1, j);
        int insert = minimumEdits(s1, s2, i, j + 1);
        int replace = minimumEdits(s1, s2, i + 1, j + 1);
        return 1 + Math.min(replace, Math.min(remove, insert));
    }
}
